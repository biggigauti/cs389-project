package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.StockRepository;
import edu.carroll.cs389.jpa.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class PopulateDatabase {
    private final StockRepository stockRepo;

    private final UserRepository userRepo;


    public PopulateDatabase(StockRepository stockRepo, UserRepository userRepo) {
        this.stockRepo = stockRepo;
        this.userRepo = userRepo;
    }

    private User createUser() {
        User myUser = new User();

        myUser.setUsername("birgir populate");

        return myUser;
    }

    public Stock createPositions(User myUser) {

        Stock stock1 = new Stock();

        stock1.setUser(myUser);
        stock1.setTicker("aapl");
        stock1.setBuyPrice(100.00f);
        stock1.setShares(2.50f);

        return stock1;
    }

    @PostConstruct
    public void loadStock() {
        List<User> users = userRepo.findByUsernameIgnoreCase("birgir populate");

        if (users.isEmpty()) {
            User userInit = createUser();
            userRepo.save(userInit);
            Stock stockInit = createPositions(userInit);
            stockRepo.save(stockInit);
        }
    }
}