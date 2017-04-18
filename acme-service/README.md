# Acme-Service

At this level, you're at the point at which something is at its best or most highly developed.

## Service call

> http://localhost:8010/?app=acme-service

> http://localhost:8010/greeting/akram

> http://localhost:8003/api/acme-service/greeting/akram

ab -n 10000 -c 50 http://localhost:8003/api/acme-service/unsafe/greeting/ffff?failureProbability=0.7

## Tracing (sleuth)

You can see :

> INFO [acme-service,15d08f544834bcfc,15d08f544834bcfc,false] 7996 --- [nio-8010-exec-1] c.t.l.s.m.s.a.rest.GreetingController    : you called for safe greeting

