# Stage build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy project files
COPY . .

# Build project
RUN mvn clean package -DskipTests

# Tìm và rename JAR file để tránh wildcard issues
RUN find target -name "*.jar" -not -name "*-sources.jar" -not -name "*-javadoc.jar" | head -1 | xargs -I {} cp {} app.jar

# Stage runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

# Create non-root user
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

# Copy JAR with specific name
COPY --from=build /app/app.jar app.jar

# Set ownership
RUN chown appuser:appgroup app.jar

# Switch to non-root user
USER appuser

EXPOSE 8080
CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
