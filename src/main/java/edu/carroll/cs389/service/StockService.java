package edu.carroll.cs389.service;


import edu.carroll.cs389.web.form.StockForm;

/**
 * The StockService Interface defines the business operations we want to execute.
 * The methods are explained in detail below.
 */
public interface StockService {
    /**
     * desc
     * @param stockForm
     */
    void createPosition(StockForm stockForm);

    /**
     * desc
     * @param stockForm
     */
    void deletePosition(StockForm stockForm);
}
