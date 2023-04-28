package com.projectdev.agenciabf;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAgenciaBfApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+3:00"));
		SpringApplication.run(ApiAgenciaBfApplication.class, args);
	}

}
