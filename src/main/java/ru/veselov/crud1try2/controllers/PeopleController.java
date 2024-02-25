package ru.veselov.crud1try2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.veselov.crud1try2.dao.PersonDAO;
import ru.veselov.crud1try2.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //get all people from DAO and send them to view
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //get one person by id from DAO and send him to the view
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
   // public String newPerson(Model model) {
    public String newPerson(@ModelAttribute("person") Person person) { //creates an empty object of the class Person with an empty constructor and adds it to the model
     //   model.addAttribute("person", new Person());  // if we use thymeleaf, we must pass an object that used in this form(add an object to model)
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {//creates an empty object of the class Person, get data from field. set data to the object. Adds an object to the model
        // creates new person and fill him with data from form
        //
        personDAO.save(person); // add person to database
        return "redirect:/people";
    }
}
