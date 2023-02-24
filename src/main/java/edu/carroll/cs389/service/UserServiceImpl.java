package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Login;
import edu.carroll.cs389.jpa.repo.LoginRepository;
import edu.carroll.cs389.web.form.LoginForm;
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

    private final LoginRepository loginRepo;

    public UserServiceImpl(LoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    // If the username provided does not already exist in the database, create a new user.
    // Makes sure we always look everything up in a non-case-sensitive manner.
    public void createUser(String username) {
        final List<Login> defaultUsers = loginRepo.findByUsernameIgnoreCase(username);
        // If there are no users with that username...
        if (defaultUsers.isEmpty()) {
            Login newUser = new Login();
            newUser.setUsername(username);
            loginRepo.save(newUser);
        }
    }

    // Checks if the user exists based on the username retrieved from the LoginForm.
    // Return true if the user exists, return false if it doesn't.
    public boolean userExists(LoginForm loginForm) {
        log.info("validateUser: User '{}' tried to log in.", loginForm.getUsername());
        // Always do the lookup in a case-insensitive manner (lower-casing the data).
        List<Login> users = loginRepo.findByUsernameIgnoreCase(loginForm.getUsername());

        // If the 'users' list returns 1 or more, the user exists. Return true.
        if (users.size() > 1) {
            log.info("validateUser: Username '{}' returned more than one record.", loginForm.getUsername());
            return true;
        }

        // If the 'users' list returns 0, the user does not exist. Return false.
        if (users.size() == 0) {
            log.info("userExists: Username '{}' does not exist.", loginForm.getUsername());
            return false;
        }

        // Else if users.size() == 1 just return true
        log.info("validateUser: User '{}' successfully logged in.", loginForm.getUsername());
        return true;
    }
}
