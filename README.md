# demojerseywithembeddedtomcat
This demo illustrates creation of a rest api using jersey and embedded tomcat. 
It is setup to utilise swagger ui to generate beautiful documentation and is a very convenient way to test api's capabilities.

Being a yogi, I have created RESTful services to manage my yoga practice and HTTP Verbs proved to be an ideal choice given api's requirements.

It is designed to run as a standalone jar. To test, build the project using 

mvn package

or simply use your favourite IDE.

Main end points

http://localhost:8080/api/practices
http://localhost:8080/api/search/practices
http://localhost:8080/api/swagger   --- swagger - ui not working yet

I used a rest client, ex. postman, to make GET, POST, PUT, DELETE request and manipulate response format, xml vs json

Once I get swagger-ui working i will post a notification out here.



