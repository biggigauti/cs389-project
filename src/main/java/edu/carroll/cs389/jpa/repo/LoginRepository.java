package edu.carroll.cs389.jpa.repo;

import java.util.List;

import edu.carroll.cs389.jpa.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The LoginRepository allows us to access data in the login table.
 *
 * To follow good practice, the LoginRepository will be accessed through a service layer
 * to separate business login from the actual data. The service is called 'UserService'.
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {
    // JPA throws an exception if we attempt to return a single object that doesn't exist, so return a list
    // even though we only expect either an empty list of a single element.
    List<Login> findByUsernameIgnoreCase(String username);
}