package edu.carroll.cs389.service;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.repo.StockRepository;
import edu.carroll.cs389.web.form.StockForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

/**
 * Desc
 */
@Service
public class StockServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final StockRepository stockRepo;

    public StockServiceImpl(StockRepository stockRepo) {
        this.stockRepo = stockRepo;
    }

    /**
     *
     * @param stockForm
     */
    public void createPosition(StockForm stockForm) {
        Stock newStock = new Stock();
        //Somehow grab the user's ID
        //newStock.setUserId();
        newStock.setTicker(stockForm.getTicker());
        newStock.setBuyPrice(stockForm.getBuyPrice());
        newStock.setShares(stockForm.getShares());
        stockRepo.save(newStock);
    }

    /**
     *
     * @param stockForm
     */
    public void deletePosition(StockForm stockForm) {

    }
}
