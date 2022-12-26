package com.example.realjpa.repository;

import com.example.realjpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {

    public Person findByFirstName(String firstName);
    public List<Person> findByAge(int age);
}
