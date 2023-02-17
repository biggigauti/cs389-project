package edu.carroll.cs389;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PortfolioController {
    private static final Logger log = LoggerFactory.getLogger(PortfolioController.class);
    @GetMapping("/portfolio")
    public String index() {
        log.info("index");
        return "portfolio";
    }
}
