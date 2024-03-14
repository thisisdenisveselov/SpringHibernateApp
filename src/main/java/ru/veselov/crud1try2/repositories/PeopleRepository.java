package ru.veselov.crud1try2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veselov.crud1try2.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}           //Integer - type of Primary Key in Person
