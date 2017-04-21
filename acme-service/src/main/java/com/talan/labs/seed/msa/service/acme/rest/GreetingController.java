package com.talan.labs.seed.msa.service.acme.rest;

import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public interface GreetingController {

    @GetMapping("/")
    List<ServiceInstance> serviceInstances(@RequestParam(value = "app", required = false) Optional<String> appName);

    @RequestMapping("/greeting/{username}")
    String safeGreeting(@PathVariable("username") String username,
                        @RequestParam(value = "failureProbability", required = false) Optional<Float> failureProbability) throws Exception;

    @RequestMapping("/unsafe/greeting/{username}")
    String unsafeGreeting(@PathVariable("username") String username,
                          @RequestParam(value = "failureProbability", required = false) Optional<Float> failureProbability) throws Exception;

    @GetMapping("/config/greeting")
    String configGreeting();

}