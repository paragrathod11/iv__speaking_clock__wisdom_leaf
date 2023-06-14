# Speaking Clock

The Speaking Clock is a Java application that converts the current time into words. It provides RESTful API endpoints for retrieving the time in words and converting custom time inputs.

## Build

To build the project, follow these steps:

1. Make sure you have Maven installed on your machine.
2. Clone this repository.
3. Navigate to the project directory.
4. Run the following command to build the project:

```shell
mvn clean install
```
The build process will compile the source code, run tests, and package the application into a JAR file.

## Deployment
To deploy the Speaking Clock application, you can follow these steps:

Ensure you have Java 8 or above installed on the deployment environment.
Copy the generated JAR file (speaking-clock-1.0.0.jar) from the target directory to your deployment server.
Run the following command to start the application: 
```shell
java -jar speaking-clock-1.0.0.jar
```

The application will start and listen on the default port 8080.

## API Endpoints
The following RESTful API endpoints are available:

GET /api/clock/currentTime: Retrieves the current time in words.
GET /api/clock/convert/{time}: Converts a custom time input to words.
For example, you can make a request to http://localhost:8080/api/clock/currentTime to get the current time in words.

## Dependencies
The project uses the following dependencies:

Spring Boot 2.5.4
Maven 3.8.2
Make sure these dependencies are available in your environment before building and running the application.
