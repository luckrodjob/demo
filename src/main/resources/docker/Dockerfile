FROM 235156076964.dkr.ecr.us-east-2.amazonaws.com/tomcat:9.0.13_jre8_x64
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080