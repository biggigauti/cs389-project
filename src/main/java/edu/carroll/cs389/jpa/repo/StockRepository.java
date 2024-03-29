package edu.carroll.cs389.jpa.repo;

import java.util.List;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The StockRepository allows us to access data in the Stock table.
 * To follow good practice, the LoginRepository will be accessed through a service layer
 * to separate business login from the actual data. The service is called 'StockService'.
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
    //Returns list regardless or length so JPA doesn't throw errors.
    List<Stock> findByTickerIgnoreCase(String ticker);
    List<Stock> findByUser(User user);
}
