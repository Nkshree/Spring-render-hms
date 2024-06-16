FROM maven:3.8.6-eclipse-temurin-17 AS build 
COPY . .
RUN maven clean package -DskipTests

FROM openjdk:17-ea-28-jdk-slim-buster
COPY --from=build /target/hms-0.0.1-SNAPSHOT.jar hms.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","hms.jar" ]  
