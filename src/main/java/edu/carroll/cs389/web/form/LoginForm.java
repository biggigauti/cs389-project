package edu.carroll.cs389.web.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginForm {

    @NotNull
    @Size(min = 6, message = "Username must be at least 6 characters long") //Modify later
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
