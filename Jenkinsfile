pipeline {
    agent any
    environment { 
        GROUP = 'Grupo4'
        dockerImage = ''
        imagename = "test_devops_usach_diplomado_imagen_docker"
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
            stage ('Build Docker') {
                steps {
                script {
                dockerImage = docker.build imagename
                }}
            }
    }
}
