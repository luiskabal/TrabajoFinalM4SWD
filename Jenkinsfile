pipeline {
    agent any
    
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
			
			stage('Test') {
                steps {
                    //sh './mvnw clean test -e' //Linux / macOS
                    bat 'mvn clean test -Dtest=UtilTest -DrequestsToEnv= test' //Windows
                }
            }
	  
            stage ('Selenium') {
                steps {
                    //sh 'mvn clean test -Dtest=SeleniumTest -DrequestsToEnv= test' //Linux / macOS
                    bat 'mvn clean test -Dtest=SeleniumTest -DrequestsToEnv= test' //Windows
                }
            }
	      stage ('Postman') {
                steps {
                    //sh 'newman run src/test/postman/dxc.json --delay-request 1000 -n 2' //Linux / macOS
                    bat 'newman run src/test/postman/dxc.json --delay-request 1000 --disable-unicode –-no-color -n 2' //Windows
                }
            }
    }
}
