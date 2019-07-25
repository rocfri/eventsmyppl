package io.eventsmyppl.controller;

import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.exception.UserNotFoundException;
import io.eventsmyppl.repository.UserRepo;
import io.eventsmyppl.services.IRegistrationSvc;
import io.eventsmyppl.services.LoginService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

   @RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody
    public boolean createUser (@RequestParam (name="username") String username, @RequestParam (name ="email") String email, 
    		@RequestParam(name="pass") String password) {
	   boolean created = false;
	   
	   try {
		   LOG.info("BackendController createUser reached");
		   UserProfile newProfile = new UserProfile(username, email, password);
		   regisRepo.addProfile(newProfile);
		   created = true;
	   }catch(Exception e) {
		   LOG.debug("Backend Controller :: Error thrown during user creation");
		   LOG.error(e.toString());
	   }
	   
	   String REGISTER_TEXT = "Backend Register found";	   
        //addProfile is still object
        
        return created;

    }
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
