# Travel app

### Description
Backend service API to search average prices of flights, visualize and delete request records.

### Get Started
You must have [JDK8](http://openjdk.java.net), [Maven](https://maven.apache.org) and [Docker](https://www.docker.com) installed.

1. Clone the repositorie using `git clone`;
2. Enter in the cloned repositorie using `cd`;
3. Choose one of the following profiles:

### Profiles
* test (Whithout Docker)
	- Execute the command `mvn clean package` to build the application
	- After build, execute the application with command `java -jar -Dspring.profiles.active=test target/travelApp-0.0.1-SNAPSHOT.jar`
	- Run the application with [H2](https://www.h2database.com) embedded database. After sucess to load the appliaciton, you can see the database console in the [link](http://localhost:8090/h2-console)
	- JDBC URL: jdbc:h2:mem:cocus_db, User Name: sa, Password: (keep empty)
	
* prod (Using docker)
	- Start docker service
	- Download postgres image with command `docker pull postgres`, to download the latest version
	- Run the database postgres image using command `docker run - 5432:5432 -v /tmp/database:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres -d postgres
	- Build docker image of the application using command `docker build -t travelapi .`
	- Start the application using command `docker run -d -e "SPRING_PROFILES_ACTIVE=prod" -p 8090:8090 --name travelapi travelapi:latest`

### Swagger Documentation
When application is alive, you can access api documentation in [address](http://localhost:8090/swagger-ui.html) for more details about services.

### API Cache
In the flight search there is a configured cache that remains active for 1 minute. The cache key is composed of the parameters informed in the search.