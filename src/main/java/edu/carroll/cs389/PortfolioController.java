package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.json.model.StockModel;
import edu.carroll.cs389.web.form.StockForm;
import edu.carroll.cs389.web.form.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
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
    @GetMapping("/portfolio")
    public String index(HttpServletRequest req) {
        String username = (String)req.getSession().getAttribute("username");
        return "portfolio";
    }

    @PostMapping(path="/portfolio", consumes="application/json")
    public void load(@Valid @RequestBody StockModel stockModel, HttpServletRequest req) {
        log.info(stockModel.toString());

        Stock stock = new Stock();
        stock.setTicker(stockModel.getTicker());
        stock.setBuyPrice(stockModel.getPrice());
        stock.setShares(stockModel.getShares());
        stock.setUser(req.getSession().getAttribute("username")); //change to user once I fix the servlet request.
    }
}
