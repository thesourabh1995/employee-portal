# Employee Portal
#### Employee portal repository consist of backend and frontend with database connectivity. In this portal, you can register employee with their details and also can see the list of users in tabular view. 
# 
# 
##### Technologies used in the project are,
###### #Backend :
* 	Java 8
*	Spring boot
*	Maven 3+
*	JPA
*	MYSQL database,
*	JUnit and Mokito for unit testing

###### #Frontend :
*	Angular 6
*	Reactive Form
*	Bootstrap
*	HTML
*	CSS
*	Jasmine & Karma for unit testing

 ##### Steps for project setup & starting the services :
 
 ###### #Backend :
 * Check the prequisite (Java 8) before running this service.
 * Now edit the application.properties file to add MYSQL database credentials.
 * Now run command mvn clean install to install the dependency and other required jar files.
 * Now run command mvn spring-boot:run to start the service.

###### #Frontend :
* Check the prerequisite (Angular 6 and bootstrap 4) before running this project.
* Now run command npm install to install the dependencies.
* Now run command ng serve --port 4200 to run the UI service.
* Since this UI is connected to backend service running localhost:8080, make sure its up and running.