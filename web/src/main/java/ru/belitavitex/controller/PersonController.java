package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.belitavitex.entity.Person;
import ru.belitavitex.service.PersonService;
import ru.belitavitex.service.PersonServiceImpl;

import java.util.List;

/**
 * Created by Dzianis on 24.06.2017.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

//    @GetMapping(path = "/AllPerson")
//    public String showRegistrationPage(Model model) {
//        model.addAttribute("persons", personService.findAll() );
//        return "all-person";
//    }

    @GetMapping(path = "/Home")
    public String showHomePage(Model model) {
        return "home";
    }
}
