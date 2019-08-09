package io.eventsmyppl.services;

import io.eventsmyppl.domain.UserProfile;

public interface ILoginSvc {

	String displayWelcome();

	int findProfile(String useremail);

	boolean validateProfile();

}
