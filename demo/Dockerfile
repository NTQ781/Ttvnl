# Sử dụng Maven để build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy toàn bộ project
COPY . .

# Build dự án (bỏ test nếu không cần)
RUN ./mvnw clean package -DskipTests

# Stage chạy app
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy file JAR từ stage build
COPY --from=build /app/target/*.jar app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
