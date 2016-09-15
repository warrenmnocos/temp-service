/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.blue.service;

import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.com.fsoft.temp.service.blue.model.domain.Person;
import ph.com.fsoft.temp.service.blue.repository.PersonRepository;

/**
 * Omit this in production.
 *
 * @author warren.nocos
 */
@Service
public class PersonDataPopulatorServiceImpl implements PersonDataPopulatorService {

    protected final PersonRepository personRepository;

    public PersonDataPopulatorServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void init() {
        populatePerson();
    }

    @Override
    @Transactional
    public void populatePerson() {
        Stream.of("Warren,Man,Nocos", "Jan Aubrey,Tomada,Tampos")
                .map(name -> name.split(","))
                .map(name -> new Person(name[0], name[1], name[2]))
                .forEach(personRepository::save);
    }

}
