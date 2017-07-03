package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.belitavitex.entity.Groups;
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

    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @GetMapping(path = "/AllPersons")
    public String showPersonPage(Model model) {
        model.addAttribute("persons", personService.findAll() );
        return "all-persons";
    }

    @GetMapping(path = "/DeletePerson/{id}")
    public String deletePerson(Model model, @PathVariable("id") long id) {
        personService.delete(id);
        return "redirect:/AllPersons";
    }

    @GetMapping(path = "/Registration")
    public String showSavePersonPage() {
        return "registration";
    }

    @PostMapping(path = "/Registration")
    public String savePerson(Person person, Model model) {
        person.setGroups(Groups.USER);
        try {
            personService.save(person);
            model.addAttribute("success", "Дорогой "
                    + person.fullName() + " , вы успешно зарегистрировались!");
            return "login";
        }catch (Exception e) {
            model.addAttribute("person", new Person());
            model.addAttribute("message", "Что-то пошло не так! Попробуйте позже!");
            return "registration";
        }
    }
}
