package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest
public class StockServiceTest {

    @Autowired
    private StockServiceImpl stockService;
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void createSuccessfulPositionTest() {
        String ticker = "brgr";
        float price = 99f;
        float shares = 99f;
        User user = new User();
        user.setUsername("birgir");

        assertTrue(stockService.createPosition(ticker, price, shares, user));
    }

    @Test
    public void createDuplicatePositionTest() {
        String ticker = "brgr";
        float price = 99f;
        float shares = 99f;
        User user = new User();
        user.setUsername("birgir");

        String ticker2 = "brgr";
        float price2 = 99f;
        float shares2 = 99f;

        assertTrue(stockService.createPosition(ticker, price, shares, user));
        assertTrue(stockService.createPosition(ticker2, price2, shares2, user));
    }

    @Test
    public void createEmptyTickerPositionTest() {
        String ticker = "";
        float price = 99f;
        float shares = 99f;
        User user = new User();
        user.setUsername("birgir");

        assertFalse(stockService.createPosition(ticker, price, shares, user));
    }

    @Test
    public void createNullTickerTest() {
        String ticker = null;
        float price = 99f;
        float shares = 99f;
        User user = new User();
        user.setUsername("birgir");

        assertFalse(stockService.createPosition(ticker, price, shares, user));
    }
}
