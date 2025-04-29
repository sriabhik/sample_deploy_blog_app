FROM openjdk:17-jdk-slim
WORKDIR /app

RUN mkdir -p /app/target
ARG  JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

FROM jenkins/jenkins:lts
USER root
RUN apt-get update && apt-get install -y docker.io
USER jenkins
ENTRYPOINT ["sh", "/usr/src/app/docker-entrypoint.sh"]