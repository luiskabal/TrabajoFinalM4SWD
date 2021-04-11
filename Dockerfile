FROM openjdk:11.0.10-jdk-buster
##FROM winamd64/openjdk:8u151-jdk-nanoserver
COPY "./target/devops-0.0.1-SNAPSHOT.jar" "devops.jar"
EXPOSE 8082
ENTRYPOINT [ "java","-jar","devops.jar" ]
