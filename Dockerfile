FROM openjdk:17-alpine

WORKDIR /app

COPY ./build/libs/2024-tm-server.jar app.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "app.jar"]