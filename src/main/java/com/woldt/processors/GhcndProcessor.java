package com.woldt.processors;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.woldt.runners.GhcndRunner;

@Component
public class GhcndProcessor extends AbstractProcessor {

	@Value("${ghcn-daily.inputFilePath}")
	private String inputFilePath;

	@Value("${ghcn-daily.outputFilePath}")
	private String outputFilePath;

	@Value("${ghcn-daily.inputFilePattern}")
	private String inputFilePattern;

	@Override
	protected List<File> getFiles() {
		final File inputDirectory = new File(inputFilePath);
		final File[] files = inputDirectory.listFiles(new FileFilter() {
			@Override
			public boolean accept(final File file) {
				return file.getName().matches(inputFilePattern);
			}
		});

		return new ArrayList<>(Arrays.asList(files));
	}

	@Override
	protected Callable<Void> getFileProcessorRunner(BlockingQueue<File> fileQueue) {
		return new GhcndRunner(fileQueue, new File(outputFilePath));
	}

	@Override
	protected String getName() {
		return "Ghcnd Processor";
	}
}
