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
    public void createUserTestOne() {
        final String username = "test birgir";
        assertTrue(userService.createUser(username));

        assertTrue(userService.userExists(username));
    }

    @Test
    public void createUserTestTwo() {
        final String user1 = "user10";
        final String user2 = "user20";

        assertTrue(userService.createUser(user1));

        assertTrue(userService.createUser(user2));

        assertTrue(userService.userExists(user1));
        assertTrue(userService.userExists(user2));
    }

    @Test
    public void createUserTestWrongName() {
        final String rightUsername = "birgir";
        final String wrongUsername = "nate";

        assertTrue(userService.createUser(rightUsername));

        assertFalse(userService.userExists(wrongUsername));
    }

    @Test
    public void createUserTestNull() {
        final String nullUser = null;

        assertFalse(userService.createUser(nullUser));

        assertFalse(userService.userExists(nullUser));
    }

    @Test
    public void createUserTestShort() {
        final String shortUser = "nate";

        assertFalse(userService.createUser(shortUser));

        assertFalse(userService.userExists(shortUser));
    }

    @Test
    public void createUserTestLong() {
        final String longUser = "naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaate";

        assertFalse(userService.createUser(longUser));

        assertFalse(userService.userExists(longUser));
    }

    @Test
    public void createUserTestEmpty() {
        final String emptyUser = "";

        assertFalse(userService.createUser(emptyUser));

        assertFalse(userService.userExists(emptyUser));
    }

    @Test
    public void userExistsTestOne() {
        final String username = "test birgir";
        assertTrue(userService.createUser(username));

        assertTrue(userService.userExists(username));
    }

    @Test
    public void userExistsTestTwo() {
        final String user1 = "user10";
        final String user2 = "user20";

        assertTrue(userService.createUser(user1));

        assertTrue(userService.createUser(user2));

        assertTrue(userService.userExists(user1));
        assertTrue(userService.userExists(user2));
    }

    @Test
    public void userExistsTestWrongName() {
        final String rightUsername = "birgir";
        final String wrongUsername = "nate";

        assertTrue(userService.createUser(rightUsername));

        assertFalse(userService.userExists(wrongUsername));
    }

    @Test
    public void userExistsTestNull() {
        final String nullUser = null;

        assertFalse(userService.createUser(nullUser));

        assertFalse(userService.userExists(nullUser));
    }

    @Test
    public void userExistsTestShort() {
        final String shortUser = "nate";

        assertFalse(userService.createUser(shortUser));

        assertFalse(userService.userExists(shortUser));
    }

    @Test
    public void userExistsTestLong() {
        final String longUser = "naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaate";

        assertFalse(userService.createUser(longUser));

        assertFalse(userService.userExists(longUser));
    }

    @Test
    public void userExistsTestEmpty() {
        final String emptyUser = "";

        assertFalse(userService.createUser(emptyUser));

        assertFalse(userService.userExists(emptyUser));
    }

    @Test
    public void getUserTestOne() {
        final String username = "testUser";

        User user = new User();

        user.setUsername(username);

        assertTrue(userService.createUser(username));

        assertEquals(user, userService.getUser(username));
    }

    @Test
    public void getUserTestTwo() {
        final String username1 = "testUser1";
        final String username2 = "testUser2";

        User user1 = new User();
        User user2 = new User();

        user1.setUsername(username1);
        user2.setUsername(username2);

        assertTrue(userService.createUser(username1));
        assertTrue(userService.createUser(username2));

        assertEquals(user1, userService.getUser(username1));
        assertEquals(user1, userService.getUser(username1));
    }

    @Test
    public void getUserTestWrongName() {
        final String rightUsername = "birgir";
        final String wrongUsername = "nate";

        User user1 = new User();

        user1.setUsername(wrongUsername);

        assertTrue(userService.createUser(rightUsername));

        assertNotEquals(user1, userService.getUser(rightUsername));
    }

    @Test
    public void getUserTestNull() {
        final String nullUser = null;

        User user = new User();

        user.setUsername(nullUser);

        assertFalse(userService.createUser(nullUser));

        assertNotEquals(user, userService.getUser(nullUser));
    }

    @Test
    public void getUserTestShort() {
        final String shortUser = "nate";

        User user = new User();

        user.setUsername(shortUser);

        assertFalse(userService.createUser(shortUser));

        assertNotEquals(user, userService.getUser(shortUser));
    }

    @Test
    public void getUserTestLong() {
        final String longUser = "naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaate";

        User user = new User();

        user.setUsername(longUser);

        assertFalse(userService.createUser(longUser));

        assertNotEquals(user, userService.getUser(longUser));
    }

    @Test
    public void getUserTestEmpty() {
        final String emptyUser = "";

        User user = new User();

        user.setUsername(emptyUser);

        assertFalse(userService.createUser(emptyUser));

        assertNotEquals(user, userService.getUser(emptyUser));
    }
}
