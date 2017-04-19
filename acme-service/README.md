# Acme-Service

This is an example of a microservice.

At this level, you're at the point at which something is at its best or most highly developed.

## Structure

This service contains:

### 1- Eureka client, to register to the server

### 2- REST services endpoints with Hystrix circuit breaker (and stream for monitoring) 

> http://localhost:8010/?app=acme-service

> http://localhost:8010/greeting/akram

> http://localhost:8003/api/acme-service/greeting/akram

> ab -n 10000 -c 50 http://localhost:8003/api/acme-service/unsafe/greeting/ffff?failureProbability=0.7

### 3- Tracing (sleuth)

You can see in the logs:

> INFO [acme-service,15d08f544834bcfc,15d08f544834bcfc,false] 7996 --- [nio-8010-exec-1] c.t.l.s.m.s.a.rest.GreetingController    : you called for safe greeting

### 4- Api documentation (Swagger2)

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
 