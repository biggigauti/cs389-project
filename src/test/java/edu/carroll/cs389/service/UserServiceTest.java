package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * The UserServiceTest class tests the user service's methods to verify that everything works as it
 * should, and we receive the expected output in the different happy, crappy, and crazy path cases.
 */
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

    @Test
    public void longUsername() {
        final String longUser = "naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaate";

        userService.createUser(longUser);

        assertFalse(userService.userExists(longUser));
    }

    @Test
    public void emptyUsername() {
        final String emptyUser = "";

        userService.createUser(emptyUser);

        assertFalse(userService.userExists(emptyUser));
    }

    @Test
    public void createNullUser() {
        assertFalse(userService.createUser(null));
    }

    @Test
    public void createEmptyUser() {
        assertFalse(userService.createUser(""));
    }

    @Test
    public void createShortUser() {
        final String shortUser = "nate";

        assertFalse(userService.createUser(shortUser));
    }

    @Test
    public void createLongUser() {
        final String longUser = "naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaate";

        assertFalse(userService.createUser(longUser));
    }

    @Test
    public void successfulUserTest() {
        assertTrue(userService.createUser("birgir"));
    }

    @Test
    public void getUserTest() {
        final String username = "testUser";

        User user = new User();

        user.setUsername(username);

        userService.createUser(username);

        assertEquals(user, userService.getUser(username));
    }

    @Test
    public void getUserShortTest() {
        final String username = "test";

        User user = new User();

        user.setUsername(username);

        userService.createUser(username);

        assertNull(userService.getUser(username));
    }

    @Test
    public void getUserLongTest() {
        final String username = "teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeest";

        User user = new User();

        user.setUsername(username);

        userService.createUser(username);

        assertNull(userService.getUser(username));
    }

    @Test
    public void getUserNullTest() {
        final String username = null;

        User user = new User();

        user.setUsername(username);

        userService.createUser(username);

        assertNull(userService.getUser(username));
    }

    @Test
    public void getUserEmptyTest() {
        final String username = "";

        User user = new User();

        user.setUsername(username);

        userService.createUser(username);

        assertNull(userService.getUser(username));
    }
}
