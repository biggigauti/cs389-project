package edu.carroll.cs389;

import edu.carroll.cs389.service.UserService;
import edu.carroll.cs389.web.form.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            log.info("loginPost: User '{}' could not be validated.", loginForm.getUsername());
            return "login";
        }
        if (!userService.validateUser(loginForm)) {
            result.addError(new ObjectError("globalError", "Username and password do not match known users"));
            return "login";
        }
        attrs.addAttribute("username", loginForm.getUsername());
        log.info("loginPost: User '{}' was redirected to /portfolio.", loginForm.getUsername());

        return "redirect:/portfolio";
    }
}