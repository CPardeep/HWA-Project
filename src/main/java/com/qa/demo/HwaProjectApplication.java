package com.qa.demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HwaProjectApplication {

	private static final Logger LOGGER = Logger.getGlobal();

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HwaProjectApplication.class, args);
		LOGGER.info(context.getBean("greeting", String.class));
	}

}
