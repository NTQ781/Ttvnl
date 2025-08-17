FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copy toàn bộ project con "demo" vào container
COPY demo/ .
# Build ứng dụng Spring Boot (tạo file jar)
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy file jar từ bước build
COPY --from=build /app/target/*.jar app.jar
# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
