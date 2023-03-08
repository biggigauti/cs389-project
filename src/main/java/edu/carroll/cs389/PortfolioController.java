package edu.carroll.cs389;

import edu.carroll.cs389.web.form.StockForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Takes HTTP requests for /portfolio and returns the portfolio template.
 */
@Controller
public class PortfolioController {
    private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);
    @GetMapping("/portfolio")
    public String index() {
        return "portfolio";
    }

    /*
    @PostMapping("/portfolio")
    //Validate userId?
    public String portfolioPost(StockForm stockForm) {

    }
     */
}
