package com.pragma.retobackend.repository;

import com.pragma.retobackend.dto.PersonDto;
import com.pragma.retobackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
