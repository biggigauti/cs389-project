package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The UserServiceImpl class is the implementation of the UserService interface. Within this class
 * we have all the business logic needed to operate our service layer.
 *
 * The current functionality allows us to create users, check if a user exists, and get
 * a user object given their username.
 *
 * A @Service annotation is used to indicate to Spring that this class provides
 * business functionalities.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository loginRepo;

    public UserServiceImpl(UserRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    /**
     * The createUser function receives a username and ensures that the username given is not null,
     * not empty, longer than 5 characters, and shorter than 20 characters. If all preliminary
     * checks are passed, look the username up in the database and ensure that no duplicate
     * username is found. If there is no duplicate username, save a new user to the database.
     *
     * @param username
     * @return boolean: Returns true/false based on ability to create the user.
     */
    public boolean createUser(String username) {
        if (username == null || username == "") {
            log.error("createUser: A username of null or empty string was submitted");
            return false;
        }

        else if (username.length() < 6) {
            log.error("createUser: User tried to insert a username less than 6 characters long");
            return false;
        }

        else if (username.length() > 20) {
            log.error("createUser: User tried to insert a username more than 20 characters long");
            return false;
        }

        else {
            final List<User> defaultUsers = loginRepo.findByUsernameIgnoreCase(username);
            // If there are no users with that username...
            if (defaultUsers.isEmpty()) {
                User newUser = new User();
                newUser.setUsername(username);
                loginRepo.save(newUser);
                log.info("createUser: User '{}' has been created successfully", username);
            }
            return true;
        }
    }

    /**
     * The userExists function receives a username and calls the loginRepo.findByUsernameIgnoreCase()
     * function to check if a user with that username already exists.
     *
     * @param username
     * @return boolean: Returns true/false based on the user existing or not.
     */
    public boolean userExists(String username) {
        log.info("userExists: Username '{}' is being validated", username);
        // Always do the lookup in a case-insensitive manner (lower-casing the data).
        List<User> users = loginRepo.findByUsernameIgnoreCase(username);

        // If the 'users' list returns 1 or more, the user exists. Return true.
        if (users.size() >= 1) {
            log.info("userExists: Username '{}' already exists", username);
            return true;
        }

        // If the 'users' list returns 0, the user does not exist. Return false.
        if (users.size() == 0) {
            log.info("userExists: Username '{}' does not exist", username);
            return false;
        }

        // Else return true
        log.info("validateUser: User '{}' has been successfully validated", username);
        return true;
    }

    /**
     * The getUser function receives a username parameter and returns the user object
     * associated with that username.
     *
     * @param username
     * @return User: Return the user if the username is valid. Null if not.
     */
    public User getUser(String username) {
        log.info("getUser: User '{}' is being retrieved", username);
        //Call loginRepo to find the user by their username
        List<User> myUser = loginRepo.findByUsernameIgnoreCase(username);

        if (myUser.isEmpty()) {
            log.info("getUser: User '{}' does not exist", username);
            return null;
        }

        log.info("getUser: User '{}' was successfully retrieved", username);
        return myUser.get(0);
    }
}