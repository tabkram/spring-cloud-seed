# Microservices Seed Project (Server)


http://localhost:8003/api/spring-heartbeat-service

## Eureka Server
It's about using an Eureka server to maintain a registry of microservices. All with the help of the spring cloud project.
UI is available here : http://127.0.0.1:8002

# API 
Eureka Server exposes a REST API specially for communicating with non-java registry clients. Documentation is available here: [Eureka-REST-operations](https://github.com/Netflix/eureka/wiki/Eureka-REST-operations)
If you don't believe : http://127.0.0.1:8002/eureka/apps

examples
Android example: (https://github.com/thomasletsch/moserp/blob/master/gui/inventory-app/app/src/main/java/org/moserp/common/rest/RestServiceRegistry.java)


## Zuul
 
 It's about an API gateway that represents a single entry point to our microservices. Zuul by itself represents a service registred in API client and it gets all registred services to know to which instance it should redirected the call

if you want to test how it works : http://localhost:8003/api/spring-heartbeat-service

### Docker (on Linux)

 To build the images use the following maven command : `sudo mvn package docker:build` on each module
 
### Old school

example :
> sudo docker container run -d -p 8002:8002 --name=eureka-server-seed eureka-server-seed:latest

### via compose

---
### references

http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html

http://www.thomas-letsch.de/2015/using-netflix-eureka-with-spring-cloud/

https://nofluffjuststuff.com/magazine/2016/06/cloud_native_spring_configuring_microservices

http://stackoverflow.com/questions/39380936/load-balancing-ribbon-and-routing-zuul-spring-rest-api-spring-data-jpa-req

https://gist.github.com/denji/8333630

http://localhost:8003/api/spring-heartbeat-service/greeting/ffff?failureProbability=1


http://callistaenterprise.se/blogg/teknik/2015/04/15/building-microservices-with-spring-cloud-and-netflix-oss-part-2/

--
#
Docker 

examples: https://github.com/fabric8io/shootout-docker-maven


---
Samples of microservices

https://github.com/ewolff/microservice


