package com.talan.labs.seed.msa.service.acme.rest;

import com.talan.labs.seed.msa.service.acme.service.GreetingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
public class GreetingControllerImpl implements GreetingController {
    private static final Log log = LogFactory.getLog(GreetingController.class);

    @Autowired
    SpanAccessor spanAccessor;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private GreetingService greetingService;

    @Value("${message:Hello default}")
    private String message;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public List<ServiceInstance> serviceInstances(@RequestParam(value = "app", required = false) Optional<String> appName) {
        return this.discoveryClient.getInstances((String) appName.orElseGet(() -> {return applicationName;}));
    }

    @Override
    public String unsafeGreeting(@PathVariable("username") String username,
                           @RequestParam(value="failureProbability", required=false)  Optional<Float> failureProbability) throws Exception {
        log.info("you called for UNsafe greeting");
        debug();
        return this.greetingService.sayHello(username, failureProbability);
    }

    @Override
    public String safeGreeting(@PathVariable("username") String username,
                           @RequestParam(value="failureProbability", required=false) Optional<Float> failureProbability) throws Exception {
        log.info("you called for safe greeting");
        debug();
        return this.greetingService.safeSayHello(username, failureProbability);
    }

    @Override
    public String configGreeting(){
        log.info("you called for config greeting");
        return this.message;
    }

    public void debug(){
        Span span = spanAccessor.getCurrentSpan();
        log.info("span id is "+span.getSpanId()+" and trace id is "+span.getTraceId() + "is exportable = "+ span.isExportable());
    }
}
