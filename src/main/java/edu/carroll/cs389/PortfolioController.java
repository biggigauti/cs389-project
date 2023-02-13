package edu.carroll.cs389;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PortfolioController {
    @GetMapping("/portfolio")
    public String portfolio() {return "portfolio";}
}
