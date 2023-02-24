package edu.carroll.cs389;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * The IndexController redirects the /(root) connection to our website to the index page.
 *
 * Spring routes HTTP requests to a controller using the annotation defined above the class.
 * For this controller, "/".
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}