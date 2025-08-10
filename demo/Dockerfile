# Sử dụng Maven + Java 17 để build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy file cấu hình Maven và tải dependencies trước
COPY pom.xml .
COPY src ./src

# Build project
RUN mvn clean package -DskipTests

# Sử dụng JDK nhẹ để chạy
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy file JAR từ bước build
COPY --from=build /app/target/*.jar app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
