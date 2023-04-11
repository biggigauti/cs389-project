package edu.carroll.cs389.service;


import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;

import java.util.List;

/**
 * The StockService is a service layer for all of our stock business operations. This is
 * the interface for that service.
 *
 * Below are all the business operations needed for our stock service.
 *
 * A service layer connects our controller and database. We should always call the database
 * from a service layer.
 */

public interface StockService {

    /**
     * The createPosition function's purpose is to receive the parameters shown below
     * and persist them to the database. A more detailed description is given
     * in the StockServiceImpl class.
     *
     * @param ticker
     * @param price
     * @param shares
     * @param user
     */
    boolean createPosition(String ticker, Float price, Float shares, User user);

    /**
     * The loadExistingPosition function's purpose is to receive the parameter show below,
     * query the database with the given user, and return the records corresponding
     * with that user. A more detailed description is given in the StockServiceImpl class.
     *
     * @param user
     * @return List<Stock>: Returns all stock positions for the given user.
     */
    List<Stock> loadExistingPosition(User user);
}
