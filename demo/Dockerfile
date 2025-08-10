# Stage build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy toàn bộ project (context là demo/ nên . = demo/)
COPY . .

# Build project
RUN mvn clean package -DskipTests

# Stage runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

# Create non-root user
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

# Copy JAR file
COPY --from=build /app/target/*.jar app.jar

# Set ownership
RUN chown appuser:appgroup app.jar

# Switch to non-root user  
USER appuser

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
