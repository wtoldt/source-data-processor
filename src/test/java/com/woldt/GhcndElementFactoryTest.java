package com.woldt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woldt.domain.GhcndElement;
import com.woldt.factories.GhcndElementFactory;


public class GhcndElementFactoryTest extends GhcndElementFactory{
	private static final Logger LOGGER = Logger.getLogger(GhcndElementFactoryTest.class);

	@Test
	public void testGetFromString() {
		final String elementId = "TMAX";
		final String chunk = "   17  C";
		final GhcndElement element = getFromString(elementId, chunk);

		Assert.assertTrue(element.getValue() == 1.7);
	}

	@Ignore
	public void dicking_around() {
		final String line = "CA001148705200202TMAX    8  C   17  C    2  C   16  C   17  C   12  C   37  C   39  C   44  C   39  C   53  C   19  C   25  C   59  C   36  C   17  C   62  C   74  C   56  C   80  C   14  C  130  C   47  C   15  C    8  C    5  C  -41  C   50  C-9999   -9999   -9999";
		final String elementId = line.substring(17, 21);
		final String stationId = line.substring(0,11);
		final String yearMonth = line.substring(11,15) + "-" + line.substring(15,17);
		final List<GhcndElement> elements = new ArrayList<>();
		for (int i=21; i+8<line.length(); i+=8) {
			final String chunk = line.substring(i, i+8);
			final GhcndElement element = getFromString(elementId, chunk);
			elements.add(element);
			final String yearMonthDay = yearMonth + "-" + ("00" + i%8).substring(1);

			//LOGGER.info(yearMonthDay);
			//LOGGER.info(chunk + ": " + element.toString());
		}

		final String year = yearMonth.substring(0,4);
		final String outputDirPath = "data/ghcn-daily/output/" + stationId + "/data/" + year;
		final File outputDir = new File(outputDirPath);
		final File outputFile = new File(outputDirPath + "/" + yearMonth + ".json");
		final Map<String, String> foo = new HashMap<String, String>();
		foo.put("hello", "world");
		outputDir.mkdirs();


		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(outputFile, elements);
		} catch (final JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
