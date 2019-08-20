package io.eventsmyppl.repository;
import io.eventsmyppl.domain.UserProfile;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepo extends CrudRepository <UserProfile, String> {

	List<UserProfile> findByuserEmail(@Param("email") String email);
	 //Basic CRUD operations attached. Can add specialized operations.
	//Customer List Search
	
	//  UserProfile findByuserEmail(String email);

	  // List<UserProfile> findByuserName(@Param("username") String username);
	}
