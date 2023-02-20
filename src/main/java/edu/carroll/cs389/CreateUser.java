package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.Login;
import edu.carroll.cs389.jpa.repo.LoginRepository;
import jakarta.annotation.PostConstruct;

import java.util.List;

public class CreateUser {
    private final LoginRepository loginRepo;

    public CreateUser(LoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    @PostConstruct
    public void createUser(String username) {
        final List<Login> checkForExistingUsername = loginRepo.findByUsernameIgnoreCase(username);
        if (checkForExistingUsername.isEmpty()) {
            Login newUser = new Login();
            newUser.setUsername(username);
            loginRepo.save(newUser);
        }
    }
}
