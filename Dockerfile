FROM openjdk:17
EXPOSE 8080
COPY target/infobip-project.jar infobip-project.jar
ENTRYPOINT ["java", "-jar","/infobip-project.jar"]