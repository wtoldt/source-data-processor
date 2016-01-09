package com.woldt;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.woldt.config.ApplicationConfig;

@SpringBootApplication
public class SourceDataProcessorApplication {

	public static void main(String[] args) {

		final SpringApplication app = new SpringApplication(ApplicationConfig.class);
		app.setBannerMode(Mode.OFF);
		app.run(args);
	}
}
