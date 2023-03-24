package edu.carroll.cs389.service;


import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The StockService Interface defines the business operations we want to execute.
 * The methods are explained in detail below.
 */

public interface StockService {

    void createPosition(String ticker, Float price, Float shares, User user);

    void deletePosition(String ticker, Float price, Float shares, User user);

    List<Stock> loadExistingPosition(String username);
}
