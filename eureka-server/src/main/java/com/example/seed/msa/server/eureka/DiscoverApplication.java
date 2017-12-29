package com.example.seed.msa.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverApplication.class, args);
	}
}
