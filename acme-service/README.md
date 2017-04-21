# Acme-Service

This is an example of a microservice.

At this level, you're at the point at which something is at its best or most highly developed.

## Structure

This service contains:

### 1- Eureka client, to register to the server

### 2- Spring config, using git 

To consume configuration from, the `config-server` in the `acme-service`:


- We add the Client Config starter in the pom.xml  

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        
- We specify the client’s app name and the location of the Config in `bootstrap.yml`

- You can see a greeting sample from config file exposed here :

> http://localhost:8010/config/greeting

- The config is not updated (refreshed) by default on push, you need to activate the refresh option with `@RefreshScope` annotation. 

Refresh scope beans are lazy proxies that initialize when they are used (i.e. when a method is called), and the scope acts as a cache of initialized values. To force a bean to re-initialize on the next method call you just need to invalidate its cache entry.

> The RefreshScope is a bean in the context and it has a public method refreshAll() to refresh all beans in the scope by clearing the target cache. There is also a refresh(String) method to refresh an individual bean by name. This functionality is exposed in the /refresh endpoint (over HTTP or JMX).

- Then we should `POST` with `curl -d {} http://localhost:8010/refresh` to trigger refresh.

- If you want toa Auto refreshing the properties on client, use `@EnableScheduled` IN your application to call `RefreshEndpoint.refresh()` directly in java code. (See more here : [#138](https://github.com/spring-cloud/spring-cloud-config/issues/138) , [#186](https://github.com/spring-cloud/spring-cloud-config/issues/186))



### 3- REST services endpoints with Hystrix circuit breaker (and stream for monitoring) 

> http://localhost:8010/?app=acme-service

> http://localhost:8010/greeting/akram

> http://localhost:8003/api/acme-service/greeting/akram

> ab -n 10000 -c 50 http://localhost:8003/api/acme-service/unsafe/greeting/ffff?failureProbability=0.7

### 4- Tracing (sleuth)

You can see in the logs:

> INFO [acme-service,15d08f544834bcfc,15d08f544834bcfc,false] 7996 --- [nio-8010-exec-1] c.t.l.s.m.s.a.rest.GreetingController    : you called for safe greeting

### 5- Api documentation (Swagger2)

The REST APi documentation in this example is based on [swagger v2](http://swagger.io/) which is based on **OpenAPI Specification** and generated a *swagger.json* endpoint here:  

> http://localhost:8010/v2/api-docs

You can change the spec path in application.yml :

```
springfox: 
  documentation: 
    swagger: 
      v2: 
        path: /api/docs
```

- Configuration
 
 The configuration in **SwaggerConfig.java** mainly centers around the Docket bean. It makes, through using `any()`, documentation for your entire API available through Swagger. *
 *(NB: this is only for demo and should be changed)**
 
 Minimal config:
 
 
     @Configuration
     @EnableSwagger2
     public class SwaggerConfig {
         @Bean
         public Docket api() {
             return new Docket(DocumentationType.SWAGGER_2)
                     .select()
                     .apis(RequestHandlerSelectors.any())
                     .paths(PathSelectors.any())
                     .build();
         }
     }
      
 NB: you need to enable CORS to be able to parse and call spec from another swagger-ui server, but only for dev environment (see *CORSFilter.java*)
 
## References
 
http://swagger-spring-boot.blogspot.fr/
 
http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

https://andressanchezblog.wordpress.com/2016/09/15/refresh-scope-in-spring-cloud/

