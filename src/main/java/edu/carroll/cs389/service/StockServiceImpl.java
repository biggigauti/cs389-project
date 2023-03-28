package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.StockRepository;
import edu.carroll.cs389.jpa.repo.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc
 */

@Service
public class StockServiceImpl implements StockService {
    private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

    private final StockRepository stockRepo;

    private final UserRepository userRepo;

    public StockServiceImpl(StockRepository stockRepo, UserRepository userRepo) {
        this.stockRepo = stockRepo;
        this.userRepo = userRepo;
    }


    public void createPosition(String ticker, Float price, Float shares, User user) {
        Stock newStock = new Stock();
        newStock.setUser(user);
        newStock.setTicker(ticker);
        newStock.setBuyPrice(price);
        newStock.setShares(shares);
        stockRepo.save(newStock);
    }


    public void deletePosition(String ticker, Float price, Float shares, User user) {
        List<Stock> stocks = stockRepo.findByTickerIgnoreCase(ticker);
        //Check that the holding belongs to our user and delete it.
    }

    public List<Stock> loadExistingPosition(HttpSession session) {
        String username = (String)session.getAttribute("username");
        List<User> users = userRepo.findByUsernameIgnoreCase(username);
        List<Stock> stocks = stockRepo.findByUser(users.get(0));
        return stocks;
    }
}
