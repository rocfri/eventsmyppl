# EventsMyPpl

Version 0.2 
This version adds a backend and front end structure based on a Vue Spring tutorial. 

Version 0.0 
Just created basic structure and setup up git for repo.

## About
This project is a social media get together application. It is set up around the idea of creating and hosting events.

The way the frontend and backend are managed is through Maven pom.xml. At this time I've mainly been doing development/figuring out the frontend tools so the DB being called and used at this time is a Json-server instance and a simple file.

## To Run
Currently, I'm focusing on getting the frontend to work as expected, so only the frontend is hooked up to run. You can run both, but no calls are going back to the backend. 

To run the front end: go into the frontend directory and run** npm run serve** like you'd run most JS frameworks. You'll need Node and Npm to do this. Additionally, you'll need json-server which you can get through npm. When you have json-server put ** json-server db.json** in terminal and it should run a dummy json server on localhost:3000. 

This setup makes developing the HTTP calls on the frontend much faster and it should more or less be the same calls when hooking up the actual backend to it (which functions on localhost: 8088)

To run the backend/whole project: There isn't much done on this part of the project yet and without it hooked up there isn't much reason to do this. I've just had a simple call make its way up, but this is mostly just as it was from the tutorial with a few minor changes. 

Still, if you'd like to run it you do this from the root file through Maven: mvn --projects backend spring-boot:run 