package edu.carroll.cs389.service;

import edu.carroll.cs389.web.form.LoginForm;

/**
 * The UserService Interface defines the business operations we want to execute.
 * The methods are explained in detail below.
 */
public interface UserService {
    /**
     * Given a LoginForm, determine if the username provided exists in the database.
     * @param form - Data containing user login information, such as username and password.
     * @return true if data exists and matches what's on record, false otherwise
     */
    boolean userExists(LoginForm form);

    /**
     * Given a username, double check that it doesn't exist. If it doesn't,
     * we make a new record in the login table of the database.
     * @param username
     */
    void createUser(String username);
}
