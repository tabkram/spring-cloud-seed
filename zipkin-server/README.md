# Zipkin-server

That's because Sleuth server is a stream Sleuth server. You're receiving spans via messaging so you need a messaging binder. Currently you can use either kafka and rabbitmq.
[reference](https://github.com/spring-cloud/spring-cloud-sleuth/issues/539).

```
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-stream-binder-rabbit</artifactId>
		</dependency>
```

# Referred examples:

https://github.com/joshlong/sleuth-blog
*