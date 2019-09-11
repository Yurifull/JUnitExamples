package com.samp.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JunitTestApplication {
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(JunitTestApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JunitTestApplication.class, args);
		
		if(context.isActive()){
			LOGGER.info("APPLICATION started.");
		}
		
	}
	
}
