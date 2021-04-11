FROM openjdk:11.0.10-jdk-buster
##FROM winamd64/openjdk:8u151-jdk-nanoserver
COPY "./build/DevOpsUsach2020-0.0.1.jar" "devops.jar"
EXPOSE 8082
ENTRYPOINT [ "java","-jar","devops.jar" ]
