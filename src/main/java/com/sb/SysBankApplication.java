package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.sb.config.SwaggerConfiguration;

@SpringBootApplication
@Import(SwaggerConfiguration.class)

public class SysBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysBankApplication.class, args);
	}

}
