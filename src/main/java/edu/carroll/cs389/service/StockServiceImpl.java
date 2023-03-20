package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.StockRepository;
import edu.carroll.cs389.jpa.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc
 */
@Service
public class StockServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final StockRepository stockRepo;

    private final UserRepository userRepo;

    public StockServiceImpl(StockRepository stockRepo, UserRepository userRepo) {
        this.stockRepo = stockRepo;
        this.userRepo = userRepo;
    }

    /**
     *
     * @param stockForm
     */
    public void createPosition(String ticker, Float price, Float shares, String username) {
        List<User> users = userRepo.findByUsernameIgnoreCase("Birgir");
        Stock newStock = new Stock();
        newStock.setUser(users.get(0));
        newStock.setTicker(ticker);
        newStock.setBuyPrice(price);
        newStock.setShares(shares);
        stockRepo.save(newStock);
    }

    /**
     *
     * @param stockForm
     */
    public void deletePosition(String ticker, Float price, Float shares, String username) {
        List<Stock> stocks = stockRepo.findByTickerIgnoreCase(ticker);
        //Check that the holding belongs to our user and delete it.
    }

    public List<Stock> loadExistingPosition(String username) {
        //Pass in user from session/cookie?
        //List<Stock> existingPosition = stockRepo.findByUser();
        return null;
    }
}
