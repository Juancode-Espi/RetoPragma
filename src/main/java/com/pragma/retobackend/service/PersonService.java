package com.pragma.retobackend.service;

import com.pragma.retobackend.dto.PersonDto;
import com.pragma.retobackend.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Service for CRUD From Person
 */

public interface PersonService {
    /**
     * create and save a person
     * @param person: persona to create
     * @return persona created
     */
    Person createPerson(PersonDto person);

    /**
     * get every person in the table
     * @return list of people
     */
    List<Person> getAllPeople();

    /**
     * update a person
     * @param idPerson: id from person to update
     * @param newPerson: data changed for a person
     * @return person updated
     */
    PersonDto updatePerson(String idPerson,PersonDto newPerson);

    /**
     * delete a person
     * @param idPerson: id person to delete
     */
    void deletePerson(String idPerson);

    PersonDto findPersonById(String idPerson);


}
