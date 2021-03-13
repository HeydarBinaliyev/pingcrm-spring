# Ping CRM created with Spring Boot backend
A demo application to illustrate how <a href="https://inertiajs.com" rel="nofollow">Inertia.js</a> can work with Spring Boot.
<br>This application translated from original <a href="https://github.com/inertiajs/pingcrm" rel="nofollow">Ping CRM</a> Laravel and Vue JS implementation(asset versioning not included)
# Installation

<br>Database
<br>For constructing database use src/main/resources/pingcrm.sql script file on mysql server

<br>Clone the repository
<br> git clone https://github.com/HeydarBinaliyev/pingcrm-spring.git

<br>Build (before build add db connection props to application.properties file)
<br>cd pingcrm-spring && mvn clean package

<br>Run
<br>cd target && java -jar dependency/webapp-runner.jar monolightdemo-0.0.1.war

<br>For rebuilding Vue JS
<br> cd src/main/resources/static && npm install && npm run watch
