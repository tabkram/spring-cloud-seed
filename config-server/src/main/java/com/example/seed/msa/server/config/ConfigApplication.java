package com.example.seed.msa.server.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
    private static final Log log = LogFactory.getLog(ConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}