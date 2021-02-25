package com.bookshop.demo.controller;

import com.bookshop.demo.controller.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model) {
        return "/genres/index";
    }

    @GetMapping("/genres/slug")
    public String genresSlug(Model model) {
        return "/genres/slug";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        return "/authors/index";
    }

    @GetMapping("/authors/slug")
    public String authorsSlug(Model model) {
        return "/authors/slug";
    }
}
