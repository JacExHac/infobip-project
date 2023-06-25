package com.infobip.project.controller;

import com.infobip.project.dto.PersonDto;
import com.infobip.project.model.Person;
import com.infobip.project.repository.PersonRepository;
import com.infobip.project.service.ConversationService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/persons")
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    public PersonDto addPerson(@RequestBody PersonDto personDto) {
        Person person = new Person();
        person.setPhoneNumber(personDto.getPhoneNumber());
        person.setFundAmount(personDto.getFundAmount());
        personRepository.save(person);
        return personDto;
    }

    @GetMapping()
    public List<PersonDto> getAllPersons() {
        List<Person> persons= personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();

        for(Person person : persons) {
            PersonDto personDto = new PersonDto();
            personDto.setPhoneNumber(person.getPhoneNumber());
            personDto.setFundAmount(person.getFundAmount());
            personDtos.add(personDto);
        }

        return personDtos;

    }
}
