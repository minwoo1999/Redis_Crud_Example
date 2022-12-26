package com.example.redis_crud.repository;

import com.example.redis_crud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,String> {

    public Person findByFirstName(String firstName);
    public List<Person> findByAge(int age);
}
