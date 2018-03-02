FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE="target/spring-boot-example-1.0-SNAPSHOT.jar"
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]