package com.example.seed.msa.service.swagger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SwaggerUIServiceApplication {
	private static final Log log = LogFactory.getLog(SwaggerUIServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SwaggerUIServiceApplication.class, args);
	}
}