package com.pragma.retobackend.service;

import com.pragma.retobackend.dto.PersonDto;
import com.pragma.retobackend.mapper.PersonMapper;
import com.pragma.retobackend.model.Person;
import com.pragma.retobackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private PersonMapper personMapper;

    private PersonServiceImpl(@Autowired PersonRepository personRepository, @Autowired PersonMapper personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Person createPerson(PersonDto personDto) {
        return personRepository.save(personMapper.toEntity(personDto));
    }

    @Override
    public List<Person> getAllPeople() {
        return null;
    }

    @Override
    public PersonDto updatePerson(String idPerson,PersonDto newPerson) {
        //long newId = Long.valueOf(idPerson);
        Person person = personRepository.findById(Long.valueOf(idPerson)).get();
        person.setAge(newPerson.getAge());
        person.setName(newPerson.getName());
        person.setIdentityNumber(newPerson.getIdentityNumber());
        personRepository.saveAndFlush(person);
        return newPerson;
    }

    @Override
    public void deletePerson(String idPerson) {
        personRepository.deleteById(Long.valueOf(idPerson));
    }

    @Override
    public PersonDto findPersonById(String idPerson) {
        Person person =  personRepository.findById(Long.valueOf(idPerson)).get();
        return personMapper.toDto(person);
    }
}
