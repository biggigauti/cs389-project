package edu.carroll.cs389;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {
    @GetMapping("/portfolio")
    public String index(@RequestParam(value="name", defaultValue="User")String name, Model model) {
        model.addAttribute("name", name);
        return "portfolio";
    }
}
