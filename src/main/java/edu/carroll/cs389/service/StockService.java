package edu.carroll.cs389.service;


import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.web.form.StockForm;

import java.util.List;

/**
 * The StockService Interface defines the business operations we want to execute.
 * The methods are explained in detail below.
 */
public interface StockService {
    /**
     * desc
     * @param stockForm
     */
    void createPosition(String ticker, Float price, Float shares, String username);

    /**
     * desc
     * @param stockForm
     */
    void deletePosition(String ticker, Float price, Float shares, String username);

    List<Stock> loadExistingPosition(String username);
}
