package edu.carroll.cs389;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {
    //MockMvc is a Spring test framework and helps the controllers by starting a Servlet container.
    //Used for testing controllers.
    @Autowired
    private MockMvc mockMvc;

    //Grabs the same page as the LoginController, the login page, and ensures that it returns
    //the expected page.
    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(get("/login")).andDo(print())
                .andExpect(status().isOk());
    }
}