package io.eventsmyppl.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import io.eventsmyppl.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(@Param("lastname") String lastname);

    List<User> findByFirstName(@Param("firstname") String firstname);

}
