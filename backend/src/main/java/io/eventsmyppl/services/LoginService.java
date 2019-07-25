package io.eventsmyppl.services;

import io.eventsmyppl.controller.BackendController;
import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.exception.UserNotFoundException;
import io.eventsmyppl.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class LoginService {

private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

	private UserRepo loginRepo;

	public void findProfile (String useremail, String username) {
		try {
		String email = loginRepo.findByuserEmail(useremail).toString();
		String user = loginRepo.findByuserName(username).toString();
				
	     LOG.info("User found with email: " + email);
	   
	}catch(Exception e) {
		LOG.error(e.toString());
		}
	}//
	
	public String displayWelcome() {
		String welcome = "Welcome: The back end sees you " ;
		return welcome;
		
	}
}//Class
