package com.pragma.retobackend.controller;

import com.pragma.retobackend.dto.PersonDto;
import com.pragma.retobackend.model.Person;
import com.pragma.retobackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/persona")
public class PersonController {
    private final PersonService personService;

    public PersonController( @Autowired PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody PersonDto person) {
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable String idPerson){
        PersonDto persomDto = personService.findPersonById(idPerson);
        return ResponseEntity.status(HttpStatus.OK).body(persomDto);
    }

    @DeleteMapping("/{idPerson}")
    public ResponseEntity<?> deletePersonById(@PathVariable String idPerson){
        personService.deletePerson(idPerson);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idPerson}")
    public ResponseEntity<PersonDto> updatePersonById(@RequestBody PersonDto newPerson, @PathVariable String idPerson){
        PersonDto personDto = personService.updatePerson(idPerson,newPerson);
        return new ResponseEntity<>(personDto, HttpStatus.ACCEPTED);
    }
}
