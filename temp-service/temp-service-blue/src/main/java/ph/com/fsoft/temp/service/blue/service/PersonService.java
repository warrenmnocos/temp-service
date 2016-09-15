/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.blue.service;

import java.util.HashSet;
import ph.com.fsoft.temp.service.blue.model.domain.Person;
import ph.com.fsoft.temp.service.blue.model.domain.PersonDto;

/**
 * The service interface
 *
 * @author warren.nocos
 */
public interface PersonService {

    /**
     * Please use DTO. For simplicity, we will return the domain model object
     * itself. So bad :(
     *
     * @param firstName the first name to be queried.
     * @return the person objects having that first name.
     */
    HashSet<Person> findByLastName(String firstName);

    HashSet<Person> findAll();

    Person findById(long id);

    void savePerson(PersonDto person);

}
