package com.talan.labs.seed.msa.service.acme.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({
        "/v1",
        "/lastest",""
})
public interface GreetingController {

    @GetMapping("/")
    @ApiOperation(value = "Get service instance ",
            notes = "Returns an awesome thing ! this returns by default to current service instance of acme-application",
            response = ServiceInstance.class,
            responseContainer="List")
    List<ServiceInstance> serviceInstances(@ApiParam(value = "if specified, the service instance could be retrieved") @RequestParam(value = "app", required = false) Optional<String> appName);

    @GetMapping("/greeting/{username}")
    @ApiOperation(value = "Safe greeting method with Hystrix circuit breaker",
            notes = "Returns a string!",
            response = String.class)
    String safeGreeting(@PathVariable("username") String username,
                        @RequestParam(value = "failureProbability", required = false) Optional<Float> failureProbability) throws Exception;

    @GetMapping("/unsafe/greeting/{username}")
    @ApiOperation(value = "UNsafe greeting method, this could fail !",
            notes = "Returns a string!",
            response = String.class)
    String unsafeGreeting(@PathVariable("username") String username,
                          @RequestParam(value = "failureProbability", required = false) Optional<Float> failureProbability) throws Exception;

    @GetMapping("/config/greeting")
    @ApiOperation(value = "Config greeting method, this get property from config-server",
            notes = "Returns a string!",
            response = String.class)
    String configGreeting();

}