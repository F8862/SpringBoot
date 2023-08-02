package com.demo.repo;

import com.demo.entities.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepoTest {
    @Autowired
    private PersonRepo personRepo;
    @Test
    void isPersonExistById() {
        Person person=new Person(1234,"Furquan","Balapur");
        personRepo.save(person);
       Boolean actualResult= personRepo.isPersonExistById(1234);
       assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down");
        personRepo.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("setting up");
    }
}