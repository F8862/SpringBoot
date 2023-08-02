package com.demo.controllers;

import com.demo.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private PersonService personServivce;

    @GetMapping("/persons")
    public ResponseEntity<?> getAllPersons(){
        return ResponseEntity.ok(this.personServivce.getAllPerson());
    }
}
