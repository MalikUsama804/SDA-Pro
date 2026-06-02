# Use lightweight Java 21 runtime
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy generated JAR
COPY ../target/SDA_Project-1.0-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run application
CMD ["java", "-jar", "app.jar"]