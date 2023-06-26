FROM openjdk:17
EXPOSE 8080
COPY target/infobip-chat-project.jar infobip-chat-project.jar
ENTRYPOINT ["java", "-jar","/infobip-chat-project.jar"]
ENV TZ=Europe/Zagreb