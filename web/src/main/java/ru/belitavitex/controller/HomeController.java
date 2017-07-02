package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belitavitex.entity.User;
import ru.belitavitex.service.PersonService;

/**
 * Created by Dzianis on 29.06.2017.
 */
@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String showHomePage() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        System.out.println(user.getFullName());
        return "home";
    }
}

