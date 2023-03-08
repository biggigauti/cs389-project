package edu.carroll.cs389.service;

import edu.carroll.cs389.PortfolioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserService.class)
public class UserServiceTest {
    @Autowired
    private MockMvc mockMvc;

    /*
    @Test
    public void userTest() throws Exception {
        mockMvc.perform();

    }
     */
}
