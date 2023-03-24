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
        final String user1 = "user1";
        final String user2 = "user2";

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


    //Create user returns true/false. Test duplicates that way, does the second user get created?
    /*
    @Test
    public void duplicateUserTest() {
        final String user1 = "birgir";
        final String user2 = "BiRgIr";

        userService.createUser(user1);
        userService.createUser(user2);

        //can i access the test database?
        //do i have to create a method in userService to check the length of this?
        final List<User> userList = loginRepo.findByUsernameIgnoreCase("Birgir");

        assertEquals(1, (float) userList.size());
    }

     */
}
