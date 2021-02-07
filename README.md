# Getting Started

## Windows

### Compile Code
* ./mvnw.cmd clean compile -e

### Test Code
* ./mvnw.cmd clean test -e

### Jar Code
* ./mvnw.cmd clean package -e

### Run Jar
* Local:      ./mvnw.cmd spring-boot:run 
* Background: nohup bash mvnw.cmd spring-boot:run &

### Testing Application
#### Ahorro y sueldo valores a modificar
* Abrir navegador: http://localhost:8080/rest/msdxc/test?sueldo=1500000&ahorro=71400000


### postman
newman run src/test/postman/dxc.json --delay-request 1000 -n 2

### SeleniumTest
mvn clean test -Dtest=SeleniumTest -DrequestsToEnv= test


## Linux

### Compile Code
* ./mvnw clean compile -e

### Test Code
* ./mvnw clean test -e

### Jar Code
* ./mvnw clean package -e

### Run Jar
* Local:      ./mvnw spring-boot:run 
* Background: nohup bash mvnw spring-boot:run &

### Testing Application
#### Ahorro y sueldo valores a modificar
* curl -X GET 'http://localhost:8080/rest/msdxc/test?sueldo=1500000&ahorro=71400000'

### Endpoints
## 10%
http://localhost:8080/rest/msdxc/dxc?sueldo=1500000&ahorro=71400000
## Saldo restante
http://localhost:8080/rest/msdxc/saldo?sueldo=1500000&ahorro=71400000
## Impuesto
http://localhost:8080/rest/msdxc/impuesto?sueldo=1500000&ahorro=71400000
