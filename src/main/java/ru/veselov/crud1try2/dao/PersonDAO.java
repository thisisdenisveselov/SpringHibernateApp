package ru.veselov.crud1try2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.veselov.crud1try2.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true) //if we only read data (good practice/no necessary)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();
        return people;
    }


    public Person show(int id) {
        return null;
    }

    public void save(Person person) {
    }

    public void update(int id, Person updatedPerson) {
    }

    public void delete(int id) {
    }
}
