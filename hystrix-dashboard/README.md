# Hystrix-Dashboard (HystrixDashboard + Turbine)

This application is playing the role of both showing the Hystrix Dashboard and exposing turbine stream

## Hystrix Dashboard

> http://localhost:8001

## Turbine Aggregator

Turbine has to know how to construct the "cluster" name (an aggregation key for sets of applications).
**The default is to use the appname, so if you don't set the clusterNameExpression you need to use a query param in the stream URL, 
e.g. /turbine.stream?cluster=CUSTOMERS (uppercased appname).**

### Config

        turbine:
          aggregator:
            clusterConfig: CUSTOMERS
          appConfig: customers
 
- you can set cluseter to default with

        clusterNameExpression: "'default'"
 
### Start 

> http://localhost:8001/turbine.stream


## References

https://dzone.com/articles/spring-cloud-with-turbine

http://stackoverflow.com/questions/32464547/spring-boot-eureka-hystrix-turbine-turbine-always-shows-0-reporting-hosts

https://exampledriven.wordpress.com/2016/07/05/spring-cloud-hystrix-example/

https://fernandoabcampos.wordpress.com/2016/05/03/hystrix-monitor-dashboard-and-turbine/