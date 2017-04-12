package com.talan.labs.seed.msa.service.acme.rest;

import com.talan.labs.seed.msa.service.acme.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GreetingControllerImpl implements GreetingController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private GreetingService greetingService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public List<ServiceInstance> serviceInstances(@RequestParam(value = "app", required = false) Optional<String> appName) {
        return this.discoveryClient.getInstances((String) appName.orElseGet(() -> {return applicationName;}));
    }

    @Override
    public String unsafeGreeting(@PathVariable("username") String username,
                           @RequestParam(value="failureProbability", required=false)  Optional<Float> failureProbability) throws Exception {
        return this.greetingService.sayHello(username, failureProbability);
    }

    @Override
    public String safeGreeting(@PathVariable("username") String username,
                           @RequestParam(value="failureProbability", required=false) Optional<Float> failureProbability) throws Exception {
        return this.greetingService.safeSayHello(username, failureProbability);
    }

}
