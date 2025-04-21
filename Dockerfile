FROM openjdk:17-jdk-slim
WORKDIR /app
RUN mkdir -p /app/target
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

