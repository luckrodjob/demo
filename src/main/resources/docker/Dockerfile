FROM jdk:1.8.92_x64
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080