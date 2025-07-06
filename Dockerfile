FROM openjdk:24-jdk
ARG JAR_FILE=target/puntos-verdes-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} /app/puntos-verdes.jar

ENTRYPOINT ["java", "-jar", "/app/puntos-verdes.jar"]