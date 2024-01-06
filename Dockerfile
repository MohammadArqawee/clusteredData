FROM openjdk:17-jre-slim
WORKDIR /app
COPY target/clusteredData.jar /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]