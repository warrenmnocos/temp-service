/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.blue.endpoint.soap;

import java.util.HashSet;
import javax.inject.Named;
import javax.jws.WebService;
import org.springframework.stereotype.Service;
import ph.com.fsoft.temp.service.blue.model.PersonDto;
import ph.com.fsoft.temp.service.blue.service.PersonService;

/**
 * The soap endpoint. I'm using decorator pattern. Prefer constructor injection
 * over property or field injection
 *
 * @author warren.nocos
 */
@Service
@WebService
public class PersonServiceSoapEndpoint implements PersonService {

    protected final PersonService personService;

    public PersonServiceSoapEndpoint(
            @Named("personServiceImpl") PersonService personService) {
        this.personService = personService;
    }

    @Override
    public HashSet<PersonDto> findByLastName(String firstName) {
        return personService.findByLastName(firstName);
    }

    @Override
    public HashSet<PersonDto> findAll() {
        return personService.findAll();
    }

    @Override
    public PersonDto findById(long id) {
        return personService.findById(id);
    }

    @Override
    public void savePerson(PersonDto person) {
        personService.savePerson(person);
    }

}
