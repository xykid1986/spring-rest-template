spring-rest-template
====================

Spring project using jersey and spring data jpa

Author: Yi Xiao, Aug 2013

Spring RESTful service (using Jersey Servlet) with SpringDataJPA used as persistence layer. A simple example is available.

Support both JSON and xml format input/output.

Support pagination.


Download and install:

git clone https://github.com/xykid1986/spring-rest-template.git

cd spring-rest-template

mvn clean install

mvn tomcat:run

The testing page is http://localhost:8080/spring-test-template/book/mybooks?page=1, check BookController for more functions.
