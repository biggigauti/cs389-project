package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.Stock;
import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.json.model.StockModel;
import edu.carroll.cs389.service.StockService;
import edu.carroll.cs389.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Takes HTTP requests for /portfolio and returns the portfolio template.
 */
@Controller
public class PortfolioController {
    private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);

    private final StockService stockService;

    private final UserService userService;

    public PortfolioController(StockService stockService, UserService userService) {
        this.stockService = stockService;
        this.userService = userService;
    }

    @GetMapping("/portfolio")
    public String index(HttpSession session, Model model) {
        if ((String)session.getAttribute("username") != null) {
            String username = (String)session.getAttribute("username");
            User user = userService.getUser(username);
            List<Stock> stocks = stockService.loadExistingPosition(session);
            model.addAttribute("stocks", stocks);
            return "portfolio";
        }
        else {
            return "redirect:/portfolio";
        }
    }


    @PostMapping(path="/portfolio", consumes="application/json")
    public void load(@Valid @RequestBody StockModel stockModel, HttpSession session) {
        if ((String)session.getAttribute("username") != null) {
            stockService.createPosition(
                    stockModel.getTicker(),
                    stockModel.getPrice(),
                    stockModel.getShares(),
                    userService.getUser((String)session.getAttribute("username"))
            );
        }
    }
}
