package edu.carroll.cs389;

import java.util.List;

import edu.carroll.cs389.jpa.model.Login;
import edu.carroll.cs389.jpa.repo.LoginRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

// This class optionally pre-populates the database with login data.  In
// a real application, this would be done with a completely different
// method.
@Component
public class DbInit {
    private static final String defaultUsername = "testing";

    private final LoginRepository loginRepo;

    public DbInit(LoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    // invoked during application startup
    @PostConstruct
    public void loadData() {
        // If the user doesn't exist in the database, populate it
        final List<Login> defaultUsers = loginRepo.findByUsernameIgnoreCase(defaultUsername);
        if (defaultUsers.isEmpty()) {
            Login defaultUser = new Login();
            defaultUser.setUsername(defaultUsername);
            loginRepo.save(defaultUser);
        }
    }
}