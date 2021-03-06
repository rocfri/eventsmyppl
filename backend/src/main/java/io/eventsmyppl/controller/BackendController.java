package io.eventsmyppl.controller;

import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.exception.UserNotFoundException;
import io.eventsmyppl.repository.UserRepo;
import io.eventsmyppl.services.ILoginSvc;
import io.eventsmyppl.services.IRegistrationSvc;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController()
@RequestMapping("/api")
public class BackendController {
//Final 
    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
   @Autowired
    private IRegistrationSvc regisRepo;
   @Autowired
    private ILoginSvc loginSvc;
   
@RequestMapping(path = "/", method = RequestMethod.GET)
	public String helloWorld(){
    String HELLO_TEXT = loginSvc.displayWelcome();

    return HELLO_TEXT;
	}
//Post User Mappings
 @PostMapping("/register")
 ResponseEntity<?> createUser (@RequestBody UserProfile userprofile) throws Exception {
	 LOG.info("BackendController createUser reached");
	 //Adding to Backend/Service
	 UserProfile checkCreate = regisRepo.addProfile(userprofile);
	 System.out.println("User Data Entered: " + checkCreate.getUserEmail() + " " + checkCreate.getUserName());
	 
	 //Checking to make sure is not null
	 if(checkCreate == null) {
		 LOG.warn("Values passed are Null");
		 return ResponseEntity.notFound().build();
	 }else {
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(checkCreate.getId())
				 .toUri();
		 return ResponseEntity.created(uri)
				 .body(checkCreate);
	 }	  
	  
}//Create user

 @PostMapping ("/login")
public void getUser() throws IOException { //return int
	 String jobject = " { \"email\" : \"emailaddress\"} ";
	 
	ObjectMapper mapper = new ObjectMapper();
	JsonNode json = mapper.readTree(jobject);
	 System.out.println("BackendController:: getUser " + json.get("email").asText()); 

	 System.out.println("BackendController :: getUser:: Reached" );
	 
	 
/*	 
	 System.out.println("Backend Controller:: getUser :: msg converter" + list);
	 //To be replaced by actual validation. First making sure I have right request for return
	boolean isValidUser = true;
		
	 if(isValidUser) {
		int userid = loginSvc.findProfile(email);
		return userid;
	 }else {
		 System.out.println(" ELSE REACHED --------------------------------------------------------------------------------->>>");
		return 0;
	 }*/
		 
  }//Post to Find
 
 @PostMapping("/error")
public String errorMsg(){
		 return "Sorry, there was an error retrieving this page. Please try again later.";
	 }
 }//Error String

/*
    @RequestMapping(path="/secured", method = RequestMethod.GET)
    public @ResponseBody String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }*/


