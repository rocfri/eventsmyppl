package io.eventsmyppl.services;

import io.eventsmyppl.controller.BackendController;
import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.exception.UserNotFoundException;
import io.eventsmyppl.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class LoginService implements ILoginSvc{

		private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
			@Autowired
			private UserRepo crudRepo;
			
			public List<UserProfile> getUsers(){
				List<UserProfile> userlist = new ArrayList<>();
				
				crudRepo.findAll().forEach(userlist::add);	
				
				return userlist;	
			}
			@Override
			//may need this to be seperate isValid and int lookup for ID
			public boolean validateProfile() {
				return true;
			}
			
			@Override
			public int findProfile (String useremail) {
			try {
						
					UserProfile userProfile = crudRepo.findByuserEmail(useremail).get(0);
					
					if (userProfile != null) {
						System.out.println("====/// User Found with username :: " + userProfile.getUserName());
						return userProfile.getId();
						/*if (userProfile.getUserPass().toString() == password) {
							System.out.println("=============// LoginSerive :: Password Accepted");
							return true;
							
						}else {
							return 0;
						}*/
					}
					
				   
				}catch(Exception e) {
					LOG.error(e.toString());
					}
			
				return 0;
			}//UserProfile
			
			public String displayWelcome() {
				String welcome = "Welcome: The back end sees you " ;
				return welcome;
				
			}
		}//Class
