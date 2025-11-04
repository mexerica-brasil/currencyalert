FROM ubuntu:latest AS BUILD

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . . 

ARG COINGECKO_API_KEY
ARG TWILIO_AUTH_TOKEN
ARG LIVECOIN_API_KEY

ENV COINGECKO_API_KEY=$COINGECKO_API_KEY
ENV TWILIO_AUTH_TOKEN=$TWILIO_AUTH_TOKEN
ENV LIVECOIN_API_KEY=$LIVECOIN_API_KEY

RUN apt-get install maven -y
RUN mvn clean install

#FROM openjdk:17-jdk

EXPOSE  8080

COPY --from=BUILD target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]