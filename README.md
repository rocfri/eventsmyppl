# EventsMyPpl
Version 0.3
DB info has been added at this stage and the user submission from frontend to backend. Unforunately, this will not be very functional as is. Wanted to make some changes to the DB as I continued with this user domain object and will be removing address from it entirely, but I was still seeing how it would pass and receive the JSON file at this point. 
 
Version 0.2 
This version adds a backend and front end structure based on a Vue Spring tutorial. 

Version 0.0 
Just created basic structure and setup up git for repo.

## About
This project is a social media get together application. It is set up around the idea of creating and hosting events.

The way the frontend and backend are managed is through Maven pom.xml. The basic project setup was borrowed from the one here: https://github.com/jonashackt/spring-boot-vuejs. 

##Project Info
A folder has been added with Practicum class materials. 

## To Run
Right now it's a little bit of a mess to run locally. You will either need to set up a DB and perhaps add the Hibernate auto create for tables and such. I recommend attempting to run without the DB settings, as the Derby dependency seems to take over and still work despite how I've altered the skeleton. Run the whole projec with  
mvn --projects backend spring-boot:run 
it'll come up on http://localhost:8088

See the Frontend
To run the front end: go into the frontend directory and run **npm run serve** like you'd run most JS frameworks. You'll need Node and Npm to do this. For developing and testing the frontend framework I had paired thsi with JSON-server. This is no longer set up in project. 
