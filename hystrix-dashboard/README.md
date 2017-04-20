# Hystrix-Dashboard (HystrixDashboard + Turbine)




# Turbine Aggregator
Turbine has to know how to construct the "cluster" name (an aggregation key for sets of applications).
**The default is to use the appname, so if you don't set the clusterNameExpression you need to use a query param in the stream URL, 
e.g. /turbine.stream?cluster=CUSTOMERS (uppercased appname).**

http://localhost:8001/turbine.stream

https://exampledriven.wordpress.com/2016/07/05/spring-cloud-hystrix-example/

https://fernandoabcampos.wordpress.com/2016/05/03/hystrix-monitor-dashboard-and-turbine/