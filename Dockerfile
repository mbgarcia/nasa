FROM openjdk:13-alpine
MAINTAINER elo7
COPY target/nasa-0.0.1.jar nasa-0.0.1.jar
ENTRYPOINT ["java","-jar","/nasa-0.0.1.jar"]
