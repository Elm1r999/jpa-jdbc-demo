package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;

        public Person findById(int id){
            return entityManager.find(Person.class, id); //JPA
        }

        public Person insert(Person person){
            return entityManager.merge(person);
        }


}
