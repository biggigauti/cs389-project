package edu.carroll.cs389;

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
    public void load(@Valid @RequestBody StockModel stockModel) {
        log.info(stockModel.toString());
    }
}
