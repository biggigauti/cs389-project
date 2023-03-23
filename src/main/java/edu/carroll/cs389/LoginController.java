package edu.carroll.cs389;

import edu.carroll.cs389.jpa.repo.UserRepository;
import edu.carroll.cs389.service.UserService;
import edu.carroll.cs389.web.form.UserForm;
import jakarta.servlet.http.HttpServletRequest;
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

/**
 * The LoginController routes HTTP requests for /login to the login page or the login html template.
 *
 * This class handles "Get" and "Post" requests.
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("loginForm", new UserForm());
        return "login";
    }


    /*
    Add HttpServletRequest to login post called req
    set attribute username to that request.
    now we can
     */


    // PostMapping from the /login page.
    // The @Valid annotation and the BindingResult check for any errors
    @PostMapping("/login")
    public String loginPost(@Valid @ModelAttribute UserForm userForm, BindingResult result, RedirectAttributes attrs, HttpServletRequest req) {
        // Reroute the user to the login page if @Valid and BindingResult find any errors.
        req.getSession().setAttribute("username", userForm.getUsername());


        String username = (String)req.getSession().getAttribute("username");
        if (result.hasErrors()) {
            log.info("loginPost: User '{}' could not be validated.", userForm.getUsername());
            return "login";
        }

        // If the user doesn't exist, call create user and reroute the user to the portfolio page.
        // The user will now be logged in.
        if (!userService.userExists(username)) {
            userService.createUser(username);
            return "redirect:/portfolio";
        }

        // Attrs allows us to send information to the following page.
        // In this case we supply the following page with the user's username.
        attrs.addAttribute("username", userForm.getUsername());
        log.info("loginPost: User '{}' was redirected to /portfolio.", userForm.getUsername());

        //If none of the conditions are met above, user exists, redirect to /portfolio page.
        return "redirect:/portfolio";
    }
}