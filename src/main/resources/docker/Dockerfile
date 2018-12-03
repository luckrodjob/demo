FROM jdk:1.8.92_x64
VOLUME /tmp
ADD demo-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java","-jar -aws.accessKeyId=AKIAITSTFJ6DTQ63SFDA  -aws.secretKey=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 -aws.region=us-east-2","/app.jar"]

EXPOSE 8080