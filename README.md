# PingCRM created with Spring Boot backend
A demo application to illustrate how <a href="https://inertiajs.com" rel="nofollow">Inertia.js</a> can work with Spring Boot.
<br>This application translated from original <a href="https://github.com/inertiajs/pingcrm" rel="nofollow">PingCrm</a> Laravel and Vue JS implementation
# Installation

<br>Database
<br>For constructing database use src/main/resources/pingcrm.sql script and run it on mysql server

<br>Clone the repository
<br> git clone https://github.com/HeydarBinaliyev/pingcrm-spring.git

<br>Build (before build add db connection props to application.properties file)
<br>cd pingcrm-spring && mvn clean package

<br>Run
<br>cd target && java -jar dependency/webapp-runner.jar monolightdemo-0.0.1.war
