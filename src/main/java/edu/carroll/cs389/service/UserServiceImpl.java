package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Login;
import edu.carroll.cs389.jpa.repo.LoginRepository;
import edu.carroll.cs389.web.form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final LoginRepository loginRepo;

    public UserServiceImpl(LoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    public void loadData(String username) {
        // If the user doesn't exist in the database, populate it.
        final List<Login> defaultUsers = loginRepo.findByUsernameIgnoreCase(username);
        if (defaultUsers.isEmpty()) {
            Login newUser = new Login();
            newUser.setUsername(username);
            loginRepo.save(newUser);
        }
    }

    public boolean userExists(LoginForm loginForm) {
        log.info("validateUser: User '{}' tried to log in.", loginForm.getUsername());
        // Always do the lookup in a case-insensitive manner (lower-casing the data).
        List<Login> users = loginRepo.findByUsernameIgnoreCase(loginForm.getUsername());

        // We expect 0 or 1, so if we get more than 1, bail out as this is an error we don't deal with properly.
        if (users.size() > 1) {
            log.info("validateUser: Username '{}' returned more than one record.", loginForm.getUsername());
            return true;
        }

        if (users.size() == 0) {
            log.info("userExists: Username '{}' does not exist.", loginForm.getUsername());
            return false;
        }

        // Else if users.size() == 1 just return true
        log.info("validateUser: User '{}' successfully logged in.", loginForm.getUsername());
        return true;
    }
}
