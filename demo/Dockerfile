FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

# Copy Maven Wrapper & pom.xml trước để cache dependencies
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

# Tải dependencies (không build code)
RUN ./mvnw dependency:go-offline

# Copy source code và build jar
COPY src ./src
RUN ./mvnw package -DskipTests

# ------------------------
# Stage 2: Run the app
# ------------------------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
