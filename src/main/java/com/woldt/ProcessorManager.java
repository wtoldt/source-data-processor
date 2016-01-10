package com.woldt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.woldt.domain.ProcessorResult;
import com.woldt.processors.AbstractProcessor;

@Component
public class ProcessorManager {
	private static final Logger LOGGER = Logger.getLogger(ProcessorManager.class);

	@Autowired
	private List<AbstractProcessor> processors;

	@PostConstruct
	public void init() {
		final List<ProcessorResult> results = new ArrayList<>();

		for (final AbstractProcessor processor : processors) {
			results.add(processor.process());
		}

		for (final ProcessorResult result : results) {
			LOGGER.info(result);
		}
	}
}
