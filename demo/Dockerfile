# Sử dụng image Maven để build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy toàn bộ dự án (bao gồm Maven Wrapper và các file cần thiết)
COPY . .

# Build ứng dụng Spring Boot (tạo file jar)
RUN ./mvnw clean package -DskipTests

# Sử dụng image Java để chạy ứng dụng
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy file jar từ bước build
COPY --from=build /app/target/*.jar app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
