# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.bluedream.spring-data.herbinate-nplus1' is invalid and this project uses 'com.bluedream.springdata.herbinatenplus1' instead.

# Getting Started

# Build
> mvn compile jib:dockerBuild

# Docker Command 
* Run
>  docker container run --detach --publish 8080:8081 --name gogolook-test1 gogolook-test1:0.0.1

### Run & Test
* [Default link](http://localhost:8081/)
* [Accessing the H2 Console](http://localhost:8081/h2-console/)
* [The default page of Swagger](http://localhost:8081/swagger-ui/)




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

