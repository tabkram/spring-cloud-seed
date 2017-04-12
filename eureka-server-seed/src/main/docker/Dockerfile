FROM openjdk:8

# Copy the built jar into the Docker image
COPY eureka-server-seed-0.0.1-SNAPSHOT.jar app.jar

# Add exser

# Expose a port outside the container
EXPOSE 8002

# Specify the command to run on startup
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]