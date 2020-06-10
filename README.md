# Travel app

### Description
Backend service API to search average prices of flights, visualize and delete request records.

### Get Started
You must have [JDK11](http://openjdk.java.net), [Maven](https://maven.apache.org) and [Docker](https://www.docker.com) installed.

1. Clone the repositorie using `git clone`
2. Enter in the cloned repositorie using `cd`

### Profiles
* test 
	- Execute the command `mvn clean package` to build the application
	- After build, execute the application with command `java -jar -Dspring.profiles.active=test target/travelApp-0.0.1-SNAPSHOT.jar`
	- Run the application with [H2](https://www.h2database.com) embedded database. After sucess to load the appliaciton, you can see the database console in the [link](http://localhost:8090/h2-console)

### Swagger Documentation
When application is alive, you can access api documentation in the [address](http://localhost:8090/swagger-ui.html)