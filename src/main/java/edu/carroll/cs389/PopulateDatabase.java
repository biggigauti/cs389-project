package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.repo.StockRepository;

public class PopulateDatabase {
    private final StockRepository stockRepo;


    public PopulateDatabase(StockRepository stockRepo) {
        this.stockRepo = stockRepo;
    }

    public void CreatePositions() {
        Stock stock = new Stock();

        stock.
    }
}
