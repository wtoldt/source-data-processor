package com.woldt.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woldt.domain.GhcndDataDay;
import com.woldt.domain.GhcndDataMonth;
import com.woldt.domain.GhcndElement;
import com.woldt.domain.GhcndWeatherCode;
import com.woldt.factories.GhcndElementFactory;
import com.woldt.factories.GhcndWeatherCodeFactory;


public class GhcndRunner implements Callable<Void>{
	private final static Logger LOGGER = Logger.getLogger(GhcndRunner.class);

	private final BlockingQueue<File> fileQueue;
	private final File outputDirectory;

	public GhcndRunner(final BlockingQueue<File> fileQueue, final File outputDirectory) {
		this.fileQueue = fileQueue;
		this.outputDirectory = outputDirectory;
	}

	@Override
	public Void call() throws Exception {
		File inputFile = null;
		while ((inputFile = fileQueue.poll()) != null) {
			final long fileStartTime = System.currentTimeMillis();
			try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
				String prevYearMonth = null;
				GhcndDataMonth dataMonth = new GhcndDataMonth();

				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					final String stationId = line.substring(0,11);
					final String yearMonth = line.substring(11,15) + "-" + line.substring(15,17);
					final String elementId = line.substring(17, 21);

					if (dataMonth.getStationId() == null) {
						dataMonth.setStationId(stationId);
					}
					if (prevYearMonth == null) {
						prevYearMonth = yearMonth;
					}
					if (!prevYearMonth.equalsIgnoreCase(yearMonth)) {
						dataMonth.setDate(yearMonth);
						write(dataMonth);
						dataMonth = new GhcndDataMonth();
						prevYearMonth = yearMonth;
					}

					for (int i=21; i<line.length(); i+=8) {
						final String chunk = line.substring(i, i+8);
						final String yearMonthDay = yearMonth + String.format("-%02d", i/8);
						GhcndDataDay dataDay = dataMonth.getDays().get(yearMonthDay);
						if (dataDay == null) {
							dataDay = new GhcndDataDay();
							dataDay.setDate(yearMonthDay);
							dataMonth.getDays().put(yearMonthDay, dataDay);
						}

						if (elementId.startsWith("WT") || elementId.startsWith("WV")) {
							final GhcndWeatherCode weathercode = GhcndWeatherCodeFactory.getFromString(elementId, chunk);
							dataDay.getWeatherCodes().put(elementId, weathercode);
						} else {
							final GhcndElement element = GhcndElementFactory.getFromString(elementId, chunk);
							dataDay.getElements().put(elementId, element);
						}
					}
				}
				LOGGER.info("finished " + inputFile.getName() + "(" + inputFile.length() + ")" +
						"in " + ((System.currentTimeMillis() - fileStartTime)/100.0) + " seconds");
			}
		}

		return null;
	}

	private void write(final GhcndDataMonth dataMonth) throws JsonGenerationException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper();
		final String year = dataMonth.getDate().substring(0,4);
		final String stationId = dataMonth.getStationId();
		final String outputDirPath = outputDirectory.getPath() + "/" + stationId + "/data/" + year;
		final File outputDir = new File(outputDirPath);
		final File outputFile = new File(outputDirPath + "/" + dataMonth.getDate() + ".json");
		outputDir.mkdirs();

		mapper.writeValue(outputFile, dataMonth);
	}
}
