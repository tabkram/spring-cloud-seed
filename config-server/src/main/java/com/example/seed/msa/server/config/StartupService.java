package com.example.seed.msa.server.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StartupService {
    private static final Log log = LogFactory.getLog(StartupService.class);
    @Value("${spring.cloud.config.server.git.username: 'Anonymous' }")
    private String gitUsername;

    @PostConstruct
    public void postConstruct() {
        log.info("StartupService constructed, Hello: "+ gitUsername);
    }
}
