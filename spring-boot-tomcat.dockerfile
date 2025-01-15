# Use the official Tomcat image from Docker Hub
FROM tomcat:10.1-jdk21-openjdk-slim

# Set environment variables for your Tomcat and project directory
ENV PROJECT_DIR=/app
ENV TOMCAT_WEBAPPS=/usr/local/tomcat/webapps

# Set the working directory
WORKDIR ${PROJECT_DIR}

# Copy the WAR file from your local project to the container
COPY ${PROJECT_DIR}/target/*.war ${TOMCAT_WEBAPPS}/ROOT.war

# Expose Tomcat's default port (8080)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
