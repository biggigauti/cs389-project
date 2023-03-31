package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.User;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest
public class StockServiceTest {

    @Autowired
    private StockServiceImpl stockService;

    User testUser = new User();


    @Test
    private void createPositionTest() {
        String ticker = "sofi";
        Float price = 10f;
        Float shares = 10f;
        User user = testUser;

        stockService.createPosition(ticker, price, shares, user);
    }
}
