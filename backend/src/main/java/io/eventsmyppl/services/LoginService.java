package io.eventsmyppl.services;

import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.repository.LoginRepo;
import org.springframework.stereotype.Service;



@Service
public class LoginService {
//testing user
	private UserProfile login1 = new UserProfile ("123", "soandso@gmail.com", "password");
	
	private LoginRepo loginRepo;

	public void addProfile (UserProfile newprofile) {

		loginRepo.save(newprofile);
	}
	
	public String displayWelcome() {
		String printUser = login1.getUserEmail();
		String welcome = "Welcome " + printUser;
		return welcome;
		
	}
}//Class
