package com.woldt.runners;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;


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
			LOGGER.info("found file: " + inputFile.getName());
		}

		return null;
	}

}
