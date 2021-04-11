pipeline {
    agent any
    environment { 
        GROUP = 'Grupo4'
        dockerImage = ''
        imagename = "test_Devops_Usach_Diplomado_Imagen_Docker"
    }
    stages {
            stage('Compile') {
                steps {
                    //sh './mvnw clean compile -e' //Linux / macOS
                    bat './mvnw.cmd clean compile -e' //Windows
                }
            }
            stage('Jar') {
                steps {
                    //sh './mvnw clean package -e' //Linux / macOS
                    bat './mvnw.cmd clean package -e -Dmaven.test.skip=true' //Windows
                }
            }
        stage ('Run Jar') {
                steps {
                //sh 'nohup bash mvnw spring-boot:run &' //Linux / macOS
                bat 'start javaw -jar target/devops-0.0.1-SNAPSHOT.jar' //Windows
                sleep 7 
                }
        }
        stage ('Build Docker') {
            steps {
                dockerImage = docker.build imagename
            
            }
        }
    }
}
