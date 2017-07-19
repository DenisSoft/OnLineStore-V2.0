package ru.belitavitex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.belitavitex.entity.Groups;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.User;
import ru.belitavitex.service.PersonService;
import ru.belitavitex.service.PersonServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @GetMapping(path = "/Admin/AllPersons")
    public String showPersonPage(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "all-persons";
    }

    @GetMapping(path = "/Admin/PersonDetails/{id}")
    public String showPersonDetails(Model model, @PathVariable("id") long id) {
        Set<Person> personInSet = new HashSet<>();
        personInSet.add(personService.findOne(id));
        model.addAttribute("persons", personInSet);
        return "all-persons";
    }

    @GetMapping(path = "/Admin/DeletePerson/{id}")
    public String deletePerson(Model model, @PathVariable("id") long id) {
        personService.delete(id);
        return "redirect:/Admin/AllPersons";
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
        } catch (Exception e) {
            model.addAttribute("person", new Person());
            model.addAttribute("message", "Что-то пошло не так! Попробуйте позже!");
            return "registration";
        }
    }

    @GetMapping(path = "/ChangingUserInformation")
    public String showUserInformation(Model model) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("person", personService.findOne(user.getId()));
        return "сhanging-user-information";
    }
}
