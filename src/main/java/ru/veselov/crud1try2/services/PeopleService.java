package ru.veselov.crud1try2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.veselov.crud1try2.models.Person;
import ru.veselov.crud1try2.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true) /*all public methods in class will have this annotation.
Same annotation above method will have priority*/
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll(); //findAll() - generates automatically
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson =  peopleRepository.findById(id);

        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) { //used for both save and update (Repository pattern)
        updatedPerson.setId(id); //possible to do it on the view side
        peopleRepository.save(updatedPerson); //save will check if person with the same id exists in the table
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
