FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn -B -U clean package

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/infra/target/infra*.jar /infra.jar
ENV TZ Europe/Istanbul
EXPOSE 8090
ENTRYPOINT ["java", "-XX:+UseG1GC", "-XX:+UseStringDeduplication", "-jar", "/infra.jar"]