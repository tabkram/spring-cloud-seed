package com.talan.labs.seed.msa.service.acme;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
public class AcmeServiceApplication {
	private static final Log log = LogFactory.getLog(AcmeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AcmeServiceApplication.class, args);
	}
}