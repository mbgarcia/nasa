## Docker running

The project contains a Dockerfile wich uses an base image from openjdk alpine project:

FROM openjdk:13-alpine
MAINTAINER elo7
COPY target/nasa-0.0.1.jar nasa-0.0.1.jar
ENTRYPOINT ["java","-jar","/nasa-0.0.1.jar"]


To create an image from our Dockerfile, we have to run ‘docker build':

$ docker build --tag=elo7:latest .


And we're able to run the container from our image:

docker run -p8080:8080 elo7:latest

