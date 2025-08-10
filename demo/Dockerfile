# Stage build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy Maven wrapper files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable and download dependencies
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build project
RUN ./mvnw clean package -DskipTests

# Stage runtime
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app

# Copy JAR file
COPY --from=build /app/target/*.jar app.jar

# Create non-root user
RUN groupadd -r appuser && useradd -r -g appuser appuser
RUN chown appuser:appuser app.jar
USER appuser

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
