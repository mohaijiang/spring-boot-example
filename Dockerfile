FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE="target/example-0.0.1-SNAPSHOT.jar"
ADD ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
