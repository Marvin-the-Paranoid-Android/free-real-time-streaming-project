# Use OpenJDK and Maven image to build the app
FROM maven:3.8.4-openjdk-8 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . /app

# Build the project using Maven (this will run 'mvn clean install')
RUN mvn clean install

# Run the app using Java once built
CMD ["java", "-jar", "target/KafkaStreamsApp.jar"]
