 package com.hospital.hms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class HmsApplication {
	final Logger LOGGER = LoggerFactory.getLogger("HmsApplication.class");
	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}

}
