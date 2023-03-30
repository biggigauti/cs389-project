package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void createUserTest() {
        final String username = "test birgir";
        userService.createUser(username);

        assertTrue(userService.userExists(username));
    }

    @Test
    public void userExistsTest() {
        final String username = "test birgir";
        userService.createUser(username);

        assertTrue(userService.userExists(username));
    }

    @Test
    public void createUsersTest() {
        final String user1 = "user10";
        final String user2 = "user20";

        userService.createUser(user1);

        userService.createUser(user2);

        assertTrue(userService.userExists(user1));
        assertTrue(userService.userExists(user2));
    }

    @Test
    public void checkNonExistingUser() {
        final String rightUsername = "birgir";
        final String wrongUsername = "nate";

        userService.createUser(rightUsername);

        assertFalse(userService.userExists(wrongUsername));
    }

    @Test
    public void nullUsername() {
        final String nullUser = null;

        userService.createUser(nullUser);

        assertFalse(userService.userExists(nullUser));
    }

    @Test
    public void shortUsername() {
        final String shortUser = "nate";

        userService.createUser(shortUser);

        assertFalse(userService.userExists(shortUser));
    }
}
