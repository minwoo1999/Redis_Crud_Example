package com.example.redis_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RealjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealjpaApplication.class, args);
    }

}
