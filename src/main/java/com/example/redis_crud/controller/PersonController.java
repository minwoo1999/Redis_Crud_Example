package com.example.redis_crud.controller;


import com.example.redis_crud.Service.PersonService;
import com.example.redis_crud.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    // CachePut 등등 Redis에 Cache한다.
    // CachePut: key값으로 return 된 결과값을 Cache에 저장합니다. 동일한 key값이 이미 있는경우 update
    // Cacheable:동일 key값이 Cache에 있는경우 Cache에서 데이터를 return한다.
    // 만약 동일한 key값이 없을경우 해당메서드를 실행하고 반환된 return 결과값를 Cache에 저장
    //CacheEvict :Cache 에서 데이터를 삭제합니다.

    @Autowired
    private PersonService personService;

    private  static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping("/create")
    @ResponseBody
    @CachePut(value = "persons", key = "#firstName")
    public Person create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age){
        log.info("create method call");
        Person p = personService.create(firstName, lastName, age);
        return p;
    }
    @RequestMapping("/get")
    @ResponseBody
    @Cacheable(value = "persons" , key = "#firstName")
    public Person getPerson(@RequestParam String firstName){
        log.info("get method call");
        return personService.getByFirstName(firstName);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @Cacheable(value = "persons")
    public List<Person> getAll(){
        log.info("getAll method call");
        return personService.getAll();
    }

    @RequestMapping("/update")
    @ResponseBody
    @CachePut(value = "persons", key = "#firstName")
    public Person update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age){
        log.info("update method call");
        Person p = personService.update(firstName, lastName, age);
        return p;
    }

    @RequestMapping("/deleteAll")
    @CacheEvict(value = "persons", allEntries = true)
    public void deleteAll(){
        log.info("deleteAll method call");
        personService.deleteAll();
    }
}
