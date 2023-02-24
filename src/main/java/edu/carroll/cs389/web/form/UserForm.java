package edu.carroll.cs389.web.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The LoginForm class allows us to store and validate the username that the user provides when
 * filling in their login information.
 *
 * We have two validation annotations in here, one ensures that the field is not empty (NotNull)
 * and the other ensures that the field includes at least x characters (Size).
 */
public class UserForm {
    @NotNull
    @Size(min = 6, message = "Username must be at least 6 characters long") //Modify later?
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
