package com.pragma.retobackend.mapper;

import com.pragma.retobackend.dto.PersonDto;
import com.pragma.retobackend.model.Person;
import lombok.Builder;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PersonMapper {

    default PersonDto toDto(Person person){
        if ( person == null ) {
            return null;
        }
        PersonDto personDto = new PersonDto();
        personDto.setIdentityNumber(person.getIdentityNumber());
        personDto.setAge(person.getAge());
        personDto.setName(person.getName());
        return personDto;
    }

    default Person toEntity(PersonDto personDto){
        if ( personDto == null ) {
            return null;
        }
        Person person = new Person(personDto);
        return person;
    }

}
