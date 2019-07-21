package io.eventsmyppl.repository;
import io.eventsmyppl.domain.UserProfile;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepo extends CrudRepository <UserProfile, String> {
	 //Basic CRUD operations attached. Can add specialized operations.
	//Customer List Search
	  List<UserProfile> findByuserEmail(@Param("userEmail") String useremail);

	   List<UserProfile> findByuserName(@Param("userName") String username);
	}
