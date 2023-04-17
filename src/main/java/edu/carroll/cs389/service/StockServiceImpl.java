package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The StockServiceImpl class is the implementation of the StockService interface. Within this class
 * we have all the business logic needed to operate our service layer.
 *
 * The current functionality allows us to create positions and load a user's existing positions.
 *
 * A @Service annotation is used to indicate to Spring that this class provides
 * business functionalities.
 */
@Service
public class StockServiceImpl implements StockService {
    private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

    private final StockRepository stockRepo;

    public StockServiceImpl(StockRepository stockRepo) {
        this.stockRepo = stockRepo;
    }


    /**
     * createPosition receives the parameters shown below, create a new Stock object, inserts
     * the given information into that object and saves it to the database by calling the
     * stockRepo.save() function.
     *
     * @param ticker
     * @param price
     * @param shares
     * @param user
     */
    public boolean createPosition(String ticker, Float price, Float shares, User user) {
        if (ticker != null && ticker != "" && price != null && shares != null && user != null) {
            Stock newStock = new Stock();
            newStock.setUser(user);
            newStock.setTicker(ticker);
            newStock.setBuyPrice(price);
            newStock.setShares(shares);
            stockRepo.save(newStock);
            log.info("createPosition: User '{}' successfully create a position for ticker '{}'", user.getUsername(), ticker);
            return true;
        }
        log.warn("createPosition: User '{}' failed to create a position for ticker '{}'", user.getUsername(), ticker);
        return false;
    }

    /**
     * loadExistingPosition simply requires the user whose records you are trying to look up.
     * Given the user, the stockRepo.findByUser() function is called. Returned by the stockRepo
     * is a list of all the stocks corresponding with that user.
     *
     * @param user
     * @return List<Stock>: Returns all stock positions for the given user.
     */
    public List<Stock> loadExistingPosition(User user) {
        List<Stock> stocks = stockRepo.findByUser(user);
        if (!stocks.isEmpty()) {
            log.info("loadExistingPosition: Positions for user '{}' have been loaded", user.getUsername());
            return stocks;
        }
        log.info("loadExistingPosition: No positions exist for user '{}'", user.getUsername());
        return null;
    }
}
