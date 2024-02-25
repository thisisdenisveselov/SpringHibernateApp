package ru.veselov.crud1try2.dao;

import org.springframework.stereotype.Component;
import ru.veselov.crud1try2.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Klod"));
        people.add(new Person(++PEOPLE_COUNT, "Lussy"));
        people.add(new Person(++PEOPLE_COUNT, "Kevit"));
        people.add(new Person(++PEOPLE_COUNT, "Stas"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
