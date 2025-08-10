# Stage build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy toàn bộ thư mục hiện tại (demo/)
COPY . .

# Cấp quyền thực thi cho mvnw và build
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Stage runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

# Tạo user không có quyền root
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

# Copy JAR file
COPY --from=build /app/target/*.jar app.jar

# Thay đổi quyền sở hữu
RUN chown appuser:appgroup app.jar

# Chuyển sang user không có quyền root
USER appuser

EXPOSE 8080
CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
