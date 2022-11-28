package com.brandlogs.inventory.api;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BrandlogsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrandlogsApiApplication.class, args);
	}

	@Bean
	public Module jsonNullableModule() {
		return new JsonNullableModule();
	}

}
