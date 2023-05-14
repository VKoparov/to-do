FROM openjdk:17-jdk-slim
# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle build files to the container
COPY . .

# Run Gradle wrapper to download dependencies and build the application
RUN ./gradlew build

# Expose the port on which the Spring application will run
EXPOSE 8080

# Set the command to run the Spring application
CMD ["java", "-jar", "build/libs/to-do-0.0.1-SNAPSHOT.jar"]
