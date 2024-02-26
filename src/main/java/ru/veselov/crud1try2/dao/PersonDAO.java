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
        people.add(new Person(++PEOPLE_COUNT, "Klod", 22, "klodhulod@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Lussy", 19, "lussypussy@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Kevit", 34, "kevinhuevin@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Stas", 51, "statsas@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
