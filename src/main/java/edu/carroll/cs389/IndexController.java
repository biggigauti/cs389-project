package edu.carroll.cs389;

import edu.carroll.cs389.service.StockServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The IndexController redirects the /(root) connection to our website to the index page.
 *
 * Spring routes HTTP requests to a controller using the annotation defined above the class.
 * For this controller, "/".
 */
@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index() {
        log.info("index: Index page loaded");
        return "index";
    }
}