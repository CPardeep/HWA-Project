package com.qa.demo.config;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public String greeting() {
		return "Welcome to the HWA project, the time is: " + LocalTime.now().toString();
	}
	
	@Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
