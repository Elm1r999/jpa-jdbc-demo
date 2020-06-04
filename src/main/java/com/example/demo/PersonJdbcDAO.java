package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ELMIR
 */
@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findByID(int id){
        return jdbcTemplate.queryForObject( "SELECT * FROM Person where id=?",
                                            new Object[]{ id    },
                                            new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findByName(String name){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE name=?",
                                            new Object[]{ name },
                                            new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteByID(int id){
        return jdbcTemplate.update("DELETE FROM PERSON WHERE id=?", new Object[]{ id });
    }

}
