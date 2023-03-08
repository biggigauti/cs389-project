package edu.carroll.cs389.jpa.repo;

import java.util.List;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The StockRepository allows us to access data in the Stock table.
 */
public interface StockRepository extends JpaRepository<Stock, Integer> {
    //Returns list regardless or length so JPA doesn't throw errors.
    List<Stock> findByTickerIgnoreCase(String ticker);
    List<Stock> findByUser(User user);
}
