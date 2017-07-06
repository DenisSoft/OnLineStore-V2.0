package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belitavitex.entity.User;
import ru.belitavitex.service.CategoryService;
import ru.belitavitex.service.PersonService;

import javax.servlet.http.HttpSession;

/**
 * Created by Dzianis on 29.06.2017.
 */
@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/")
    public String showHomePage(HttpSession session) {
        session.setAttribute("categories", categoryService.findAll());
        return "home";
    }
}

