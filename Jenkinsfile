pipeline {
    agent any
    
    stages {
            stage('Compile') {
                steps {
                    sh './mvnw clean compile -e' //Linux / macOS
                    //bat './mvnw.cmd clean compile -e' //Windows

                }
            }
            
            stage('Test') {
                steps {
                    sh './mvnw clean test -e' //Linux / macOS
                    //bat './mvnw.cmd clean test -e' //Windows
                }
            }
            stage('Jar') {
                steps {
                    sh './mvnw clean package -e' //Linux / macOS
                    //bat './mvnw.cmd clean package -e' //Windows
                }
            }
            stage ('Run Jar') {
                steps {
                    sh 'nohup bash mvnw spring-boot:run &' //Linux / macOS
                    //bat 'nohup bash mvnw.cmd spring-boot:run &' //Windows
                }
            }
            stage ('Postman') {
                sh 'newman run src/test/postman/dxc.json --delay-request 1000 -n 2' //Linux / macOS
                //bat 'newman run src/test/postman/dxc.json --delay-request 1000 -n 2' //Windows
            }
            stage ('Selenium') {
                sh 'mvn clean test -Dtest=SeleniumTest -DrequestsToEnv= test' //Linux / macOS
                //bat 'mvn clean test -Dtest=SeleniumTest -DrequestsToEnv= test' //Windows
            }
    }
}
