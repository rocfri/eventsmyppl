package io.eventsmyppl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eventsmyppl.domain.UserProfile;
import io.eventsmyppl.repository.UserRepo;

@Service
public class RegisterService implements IRegistrationSvc {
	@Autowired
	private UserRepo crudRepo;
	
	@Override
	public UserProfile addProfile (UserProfile newprofile) {
		System.out.println("Backend Register Service Reached:: With" + newprofile.getUserEmail());
		return crudRepo.save(newprofile);
	}
	
}
