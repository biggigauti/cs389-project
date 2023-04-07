package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.web.form.UserForm;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * The UserService is a service layer for all of our user business operations. This is the
 * interface for that service.
 *
 * Below are all the business operations needed for our user service.
 *
 * A service layer connects our controller and database. We should always call the database
 * from a service layer.
 */
public interface UserService {

    /**
     * userExists check if a user with that username currently exists in the database. A full
     * description of functionality and logic is given in the UserServiceImpl class.
     *
     * @param username
     * @return boolean: Returns true or false based on username existence.
     */
    boolean userExists(String username);

    /**
     * Given a username, create the user. A full description of functionality and logic
     * is given in the UserServiceImpl class.
     *
     * @param username
     */
    boolean createUser(String username);

    /**
     * Get a User object when given a username. A full description of functionality and logic
     * is given in the UserServiceImpl class.
     *
     * @param username
     * @return User: Returns the User corresponding with the username.
     */
    User getUser(String username);
}
