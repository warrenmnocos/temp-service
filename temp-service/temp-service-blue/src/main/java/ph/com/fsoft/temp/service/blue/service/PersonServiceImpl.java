/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.blue.service;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.com.fsoft.temp.service.blue.model.domain.Person;
import ph.com.fsoft.temp.service.blue.model.domain.PersonDto;
import ph.com.fsoft.temp.service.blue.repository.PersonRepository;

/**
 * Service implementation. Use {@link Transactional#readOnly() } set to true,
 * for read access.
 *
 * @author warren.nocos
 */
@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    protected final PersonRepository personRepository;

    /**
     * I prefer {@link Inject} because it is the standard way of injecting
     * dependencies. ALso, please prefer CONSTRUCTOR INJECTION, because it
     * provides a contract that this object will not be created unless
     * dependencies are provided :).
     *
     * @param personRepository
     */
    @Inject
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public HashSet<Person> findAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Person findById(long id) {
        return personRepository.findOne(id);
    }

    @Override
    public HashSet<Person> findByLastName(String firstName) {
        return personRepository.findByLastName(firstName)
                .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Use {@link Transactional} for persistence.
     *
     * @param person the person
     */
    @Override
    @Transactional
    public void savePerson(PersonDto person) {
        personRepository.save(new Person(person.getFirstName(),
                person.getMiddleName(), person.getLastName()));
    }

}
