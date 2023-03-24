package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.json.model.StockModel;
import edu.carroll.cs389.service.StockService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Takes HTTP requests for /portfolio and returns the portfolio template.
 */
@Controller
public class PortfolioController {
    private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);

    private final StockService stockService;

    public PortfolioController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/portfolio")
    public String index(HttpServletRequest req) {
        return "portfolio";
    }

    @PostMapping(path="/portfolio", consumes="application/json")
    public void load(@Valid @RequestBody StockModel stockModel, HttpServletRequest req) {
        log.info(stockModel.toString());

        /*
        Stock stock = new Stock();
        stock.setTicker(stockModel.getTicker());
        stock.setBuyPrice(stockModel.getPrice());
        stock.setShares(stockModel.getShares());
        stock.setUser((User)req.getSession().getAttribute("user"));

         */

        stockService.createPosition(
                stockModel.getTicker(),
                stockModel.getPrice(),
                stockModel.getShares(),
                (User)req.getSession().getAttribute("user")
                );
    }
}
