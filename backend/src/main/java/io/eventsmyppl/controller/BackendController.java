package io.eventsmyppl.controller;

import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.exception.UserNotFoundException;
import io.eventsmyppl.repository.UserRepo;
import io.eventsmyppl.services.IRegistrationSvc;
import io.eventsmyppl.services.LoginService;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);


    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private IRegistrationSvc regisRepo;

    @Autowired
	private LoginService loginService;



@RequestMapping(path = "/", method = RequestMethod.GET)
	public String helloWorld(){
    String HELLO_TEXT = loginService.displayWelcome();

    return HELLO_TEXT;
	}

 @PostMapping("/register")
 ResponseEntity<?> createUser (@RequestBody UserProfile userprofile) throws URISyntaxException {
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
/*
 @GetMapping(path = "/user/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {

       
    }

    @RequestMapping(path="/secured", method = RequestMethod.GET)
    public @ResponseBody String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }*/

}
