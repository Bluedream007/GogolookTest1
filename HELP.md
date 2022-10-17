# Read Me First
A test project - 
Implement a Restful task list API as well as run this application in container.

- Runtime Environment Requirement
  - JDK - Java 17
  - Build Tool - Maven 3
  - IDE Tool - Intellij IDEA
  - Database - H2 In-memory DB  
  - Docker

# Getting Started
# Build
- Build Jar file
> mvn clean package -Dmaven.test.skip=true
- Build Docker image
> mvn compile jib:dockerBuild

# Docker Command 
* Run
- Get image from local
>  docker container run --detach --publish 8080:8081 --name gogolook-test1 gogolook-test1:0.0.1
- Get image from Docker Hub
> docker run -p 8081:8081 --name gogolook-test1 charlotte007/gogolook-test1:0.0.1
or 
> docker container run --detach --publish 8080:8081 --name gogolook-test1 charlotte007/gogolook-test1:0.0.1

### Run & Test
* [Default Test Page](http://localhost:8081/)
* [The default page of Swagger](http://localhost:8081/swagger-ui/)
* [Accessing the H2 Console](http://localhost:8081/h2-console/)
  - ID: sa, Password: password
  

### Test Data Example
- 1.POST /task  (create task)
{
"name": "買午餐2"
}
- 2.PUT /task/1 (update task)
{
"name": "買早餐",
"status": true,
"id": 1
}
- 3.DELETE /task/1 (delete task)





### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


#### Ref. links
* [Spring Boot With H2 Database](https://www.baeldung.com/spring-boot-h2-database)
* [Testing in Spring Boot](https://www.baeldung.com/spring-boot-testing)
* [@DataJpaTest example for Spring Data Repository Unit Test](https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)
