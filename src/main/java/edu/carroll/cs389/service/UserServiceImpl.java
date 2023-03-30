package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.UserRepository;
import edu.carroll.cs389.web.form.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The UserServiceImpl class is the implementation of our UserService interface.
 * This class includes two methods that provide the necessary logic to implement our user service.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository loginRepo;

    public UserServiceImpl(UserRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    /**
     * If the username provided does not already exist in the database, create a new user.
     * Makes sure we always look everything up in a non-case-sensitive manner.
     * @param username
     */
    public void createUser(String username) {
        if (username == null) {
            log.error("createUser: A username of null was submitted.");
        }

        else if (username.length() < 6) {
            log.error("createUser: User tried to insert username with less than 6 characters.");
        }

        else if (username != null && username.length() >= 6) {
            final List<User> defaultUsers = loginRepo.findByUsernameIgnoreCase(username);
            // If there are no users with that username...
            if (defaultUsers.isEmpty()) {
                User newUser = new User();
                newUser.setUsername(username);
                loginRepo.save(newUser);
            }
        }
    }

    /**
     * Checks if the user exists based on the username retrieved from the LoginForm.
     * Return true if the user exists, return false if it doesn't.
     * @param userForm - Data containing user login information, such as username.
     * @return true if the user exists, false if the user does not exist.
     */
    public boolean userExists(String username) {
        log.info("validateUser: User '{}' tried to log in.", username);
        // Always do the lookup in a case-insensitive manner (lower-casing the data).
        List<User> users = loginRepo.findByUsernameIgnoreCase(username);

        // If the 'users' list returns 1 or more, the user exists. Return true.
        if (users.size() > 1) {
            log.info("validateUser: Username '{}' returned more than one record.", username);
            return true;
        }

        // If the 'users' list returns 0, the user does not exist. Return false.
        if (users.size() == 0) {
            log.info("userExists: Username '{}' does not exist.", username);
            return false;
        }

        // Else if users.size() == 1 just return true
        log.info("validateUser: User '{}' successfully logged in.", username);
        return true;
    }

    public User getUser(String username) {
        List<User> myUser = loginRepo.findByUsernameIgnoreCase(username);

        return myUser.get(0);
    }
}