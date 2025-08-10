# Sử dụng JDK để build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy toàn bộ dự án vào container
COPY . .

# Build ứng dụng (bỏ tests nếu không cần)
RUN ./mvnw clean package -DskipTests

# Stage chạy ứng dụng
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy file jar từ stage build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
