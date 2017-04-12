# Acme-Service

At this level, you're at the point at which something is at its best or most highly developed.

> http://localhost:8010/?app=acme-service

> http://localhost:8010/greeting/akram

> http://localhost:8003/api/acme-service/greeting/akram

ab -n 10000 -c 50 http://localhost:8003/api/acme-service/unsafe/greeting/ffff?failureProbability=0.7