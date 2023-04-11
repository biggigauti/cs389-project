package edu.carroll.cs389;

import edu.carroll.cs389.jpa.model.User;
import edu.carroll.cs389.jpa.repo.UserRepository;
import edu.carroll.cs389.service.UserService;
import edu.carroll.cs389.web.form.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    /**
     * Handles get requests for the login controller. Anything pointed at "/login".
     *
     * @param model
     * @return HTML template for the login page.
     */
    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "login";
    }

    /**
     * Handles get requests for the "/logout" path. Redirects the user to the login page and
     * invalidates the session.
     *
     * @param session
     * @return HTML template for the login page.
     */
    @GetMapping("/logout")
    public String logoutGet(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // PostMapping from the /login page.
    // The @Valid annotation and the BindingResult check for any errors

    /**
     * Handles post requests for the login controller. Once the user enters their login
     * information the loginPost method validates the results, checks for errors, and if
     * everything looks correct and safe, redirect the user to their portfolio page.
     * If errors are found, send the user back to the login page.
     *
     * @param userForm
     * @param result
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String loginPost(@Valid @ModelAttribute UserForm userForm, BindingResult result, HttpSession session) {
        // Attach the user's username to their session to be able to pull that information later.
        session.setAttribute("username", userForm.getUsername());

        // Reroute the user to the login page if @Valid and BindingResult find any errors.
        if (result.hasErrors()) {
            log.info("loginPost: User '{}' could not be validated.", userForm.getUsername());
            return "login";
        }

        // If the user doesn't exist, call create user and reroute the user to the portfolio page.
        // The user will now be logged in.
        if (!userService.userExists(userForm.getUsername())) {
            userService.createUser(userForm.getUsername());
            return "redirect:/portfolio";
        }

        // Attrs allows us to send information to the following page.
        // In this case we supply the following page with the user's username.
        log.info("loginPost: User '{}' was redirected to /portfolio.", userForm.getUsername());

        //If none of the conditions are met above, user exists, redirect to /portfolio page.
        return "redirect:/portfolio";
    }
}