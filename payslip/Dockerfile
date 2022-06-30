# For Java 8, try this
FROM maven:3.8.5-openjdk-8 AS builder
COPY /src /home/app/src
COPY /pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true
# Package stage
FROM openjdk:8-jdk
ARG JAR_FILE=./home/app/target/*.jar
COPY --from=builder ${JAR_FILE} /app.jar

RUN apt-get update && \
    apt-get install jq -y
RUN mkdir -p /temp/upload
EXPOSE 8091
CMD ["java", "-jar", "/app.jar"]
