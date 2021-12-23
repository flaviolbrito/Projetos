FROM openjdk:11.0.12-jre-slim-buster
RUN mkdir /app
COPY /target/*.jar /app/app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "/app/app.jar"]