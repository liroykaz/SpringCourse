package org.bookshop.web.controllers;

import org.apache.log4j.Logger;
import org.bookshop.app.exceptions.BookShelfLoginException;
import org.bookshop.web.dto.LoginForm;
import org.bookshop.app.services.LoginService;
import org.bookshop.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping(value = "/login")
public class LoginController {

    private final Logger logger = Logger.getLogger(LoginController.class);
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        logger.info("GET /login returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/login/auth")
    public String authenticate(LoginForm loginFrom) throws BookShelfLoginException {
        if (loginService.authenticate(loginFrom)) {
            logger.info("login OK redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            logger.info("login FAIL redirect back to login");
            throw new BookShelfLoginException("Invalid user or password");
        }
    }

    @PostMapping("/login/register")
    public String register(LoginForm loginFrom) {
        System.out.println("register" + loginFrom.getPassword() + " " + loginFrom.getUsername());
        return "";
    }

    @GetMapping("/register")
    public String openRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register_page";
    }

    @PostMapping("/register")
    public String register(User user) {
        loginService.register(user);
        return "redirect:/login";
    }


}
