# VideoGameInventory
# Product description
This is a backend service that serves as an inventory for Video Games. It contains information such as the title, platform, and if the user finished the game. 
It uses teh following technologies: Java 8, JDBC, Servlets, Tomcat 9.0, PostgreSQL, JUnit4, Maven, jlog4j...

## GET all video games
http://localhost:8080/VideoGameInventory/VideoGameServlet

## GET video games by completion status or id
http://localhost:8080/VideoGameInventory/VideoGameServlet?isFinished=true
http://localhost:8080/VideoGameInventory/VideoGameServlet?id=1
...
## POST video game
This will create a video game and add it to db.
http://localhost:8080/VideoGameInventory/VideoGameServlet?title=Pokemon+Ruby&platform=GBA&isFinished=false

## PUT video game
This will update a video game based on id
http://localhost:8080/VideoGameInventory/VideoGameServlet?id=11&title=New+Title&platform=newPlatform&isFinished=false

## DELETE video game
This will delete a video game based on id
http://localhost:8080/VideoGameInventory/VideoGameServlet?id=11

## Prerequisites
You will have to download the following in order to set up the app locally:
- maven
- tomcat 9.0
- jdk8
- Running PostgreSQL DB

## Setup

1. clone the application from repository
 git clone https://github.com/yasmine-sorhovigarat/VideoGameInventory.git

2. Run `MakeDatabaseScript.sql` to set up the database. 

3. Setup tomcat to run locally. 

4. Use Postman to GET/POST/PUT/DELETE
    
## Logging
The following are logged: 

1. When an admin signs in. 
2. When a game is deleted.
3. When a game is created. 
