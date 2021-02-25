package org.bookshop.web.controllers;

import org.bookshop.app.exceptions.BookShelfLoginException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ErrorController {

    @GetMapping("/404")
    public String notFoundError() {
        return "errors/404";
    }

    /* такой метод можно определить в конкретном контроллере и там задать определенную реализацию.
        В данном моменте в @ControllerAdvice контроллере этот метод дудет вызываться для всех контроллеров */
    @ExceptionHandler(BookShelfLoginException.class)
    public String handleError(Model model, BookShelfLoginException ex) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "errors/404";
    }
}
