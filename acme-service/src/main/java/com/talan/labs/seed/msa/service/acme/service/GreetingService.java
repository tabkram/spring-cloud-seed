package com.talan.labs.seed.msa.service.acme.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    @HystrixCommand
    public String sayHello(String username, Optional<Float> failureProbability) throws Exception {
        SleepService.sleepAndCrash(failureProbability);
        return String.format("Hello %s!\n", username);
    }

    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String safeSayHello(String username, Optional<Float> failureProbability) throws Exception {
       return sayHello(username, failureProbability);
    }

    public String defaultGreeting(String username, Optional<Float> failureProbability) {
        return String.format("Hello User!\n");
    }
}
