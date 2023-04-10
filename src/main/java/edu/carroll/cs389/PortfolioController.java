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
 * This class handles gets and posts for the portfolio page, "/portfolio".
 *
 * This class has the usual GetMapping to display HTML templates. It also has
 * PostMapping that handles the user's stock submissions.
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

    /**
     * First we verify that the user's session is still active. If it isn't, send them
     * to the login page. If the session is active, get the user's stock holdings and
     * display their portfolio page.
     *
     * @param session
     * @param model
     * @return portfolio page upon successful verification. login page upon unsuccessful verification.
     */
    @GetMapping("/portfolio")
    public String index(HttpSession session, Model model) {
        // If session is invalid.
        if ((String)session.getAttribute("username") != null) {
            String username = (String)session.getAttribute("username");
            User user = userService.getUser(username);
            List<Stock> stocks = stockService.loadExistingPosition(user);
            model.addAttribute("stocks", stocks);
            return "portfolio";
        }
        else {
            return "redirect:/login";
        }
    }

    /**
     * Handles post requests for the portfolio controller. This PostMapping is set to consume
     * JSON strings. We are expecting the user's stock submissions to be posted to "/portfolio"
     * in the form of JSON strings. If the user's session is valid and the information is
     * received, create a new Stock object and save it to the database.
     *
     * @param stockModel
     * @param session
     */
    @PostMapping(path="/portfolio", consumes="application/json")
    public void load(@Valid @RequestBody StockModel stockModel, HttpSession session) {
        // If session is invalid.
        if ((String)session.getAttribute("username") != null) {
            // Saves the information to database.
            stockService.createPosition(
                    stockModel.getTicker(),
                    stockModel.getPrice(),
                    stockModel.getShares(),
                    userService.getUser((String)session.getAttribute("username"))
            );
        }
    }
}
