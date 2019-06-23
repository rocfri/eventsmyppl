package io.eventsmyppl.repository;
import io.eventsmyppl.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;


public interface LoginRepo extends CrudRepository <UserProfile, String> {
	 //Basic CRUD operations attached. Can add specialized operations.
	}
