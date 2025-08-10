# Sử dụng JDK 17 để build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy Maven Wrapper và file cấu hình
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies trước để cache
RUN ./mvnw dependency:go-offline

# Copy toàn bộ source
COPY src ./src

# Build jar
RUN ./mvnw package -DskipTests

# Chạy ứng dụng
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
