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

    User testUser = new User();
    Stock testStock = new Stock();


    @Test
    private void createPositionTest() {
        String ticker = "sofi";
        Float price = 10f;
        Float shares = 10f;
        User user = testUser;

        testStock.setTicker(ticker);
        testStock.setBuyPrice(price);
        testStock.setShares(shares);
        testStock.setUser(testUser);

        stockService.createPosition(ticker, price, shares, user);

        List<Stock> stocks = stockService.loadExistingPosition(testUser);

        assertTrue(testStock == stocks.get(0));
    }
}
