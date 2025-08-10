# Stage build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy Maven wrapper và pom.xml trước để cache dependencies
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Cấp quyền thực thi cho mvnw và download dependencies
RUN chmod +x ./mvnw && ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build project
RUN ./mvnw clean package -DskipTests

# Stage runtime - Sử dụng JRE để tiết kiệm dung lượng
FROM eclipse-temurin:17-jre
WORKDIR /app

# Tạo user không có quyền root để bảo mật
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

# Copy JAR file từ build stage
COPY --from=build /app/target/*.jar app.jar

# Thay đổi quyền sở hữu file
RUN chown appuser:appgroup app.jar

# Chuyển sang user không có quyền root
USER appuser

# Expose port
EXPOSE 8080

# Health check (tùy chọn - có thể xóa nếu không cần)
# HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 \
#   CMD curl -f http://localhost:8080/actuator/health || exit 1

# Chạy ứng dụng với JVM options tối ưu
CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
