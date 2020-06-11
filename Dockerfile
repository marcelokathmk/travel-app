FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/travelApp-0.0.1-SNAPSHOT.jar travelapi.jar
ENTRYPOINT ["java", "-jar", "/travelapi.jar"]