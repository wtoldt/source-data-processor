package com.woldt.processors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.woldt.domain.ProcessorResult;

public abstract class AbstractProcessor {
	private static final Logger LOGGER = Logger.getLogger(AbstractProcessor.class);

	@Value("${threadCount}")
	private int threadCount;

	abstract protected List<File> getFiles();

	abstract protected Callable<Void> getFileProcessorRunner(final BlockingQueue<File> fileQueue);

	public ProcessorResult process() {
		final ProcessorResult result = new ProcessorResult();

		final BlockingQueue<File> fileQueue = new LinkedBlockingQueue<>(getFiles());
		final ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

		final List<Future<?>> futures = new ArrayList<>();
		for (int i = 0; i < threadCount; i++) {
			futures.add(executorService.submit(getFileProcessorRunner(fileQueue)));
		}
		executorService.shutdown();

		for (final Future<?> future : futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				LOGGER.error("future.get error");
				e.printStackTrace();
			}
		}

		return null;
	}
}
