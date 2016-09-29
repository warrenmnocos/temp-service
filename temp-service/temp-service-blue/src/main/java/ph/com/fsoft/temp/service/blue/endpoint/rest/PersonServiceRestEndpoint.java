/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.blue.endpoint.rest;

import java.util.HashSet;
import javax.inject.Named;
import javax.inject.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ph.com.fsoft.temp.service.blue.model.PersonDto;
import ph.com.fsoft.temp.service.blue.service.PersonService;
import ph.com.fsoft.temp.service.blue.service.PersonServiceImpl;

/**
 *
 * @author warren.nocos
 */
@RestController
@RequestMapping("api/rest/person")
public class PersonServiceRestEndpoint implements PersonService {

    protected final PersonService personService;

    /**
     * Since we have multiple beans for {@link PersonService} because we used
     * decorator pattern (with multiple instances used for service, rest and
     * soap), we will tell Spring to inject the service implementation
     * {@link PersonServiceImpl}. This is analogous to {@link Qualifier
     * } but we will use {@link Named} to conform to standards.
     *
     * @param personService the service
     */
    public PersonServiceRestEndpoint(
            @Named("personServiceImpl") PersonService personService) {
        this.personService = personService;
    }

    @Override
    @RequestMapping(params = "id")
    public PersonDto findById(@RequestParam("id") long id) {
        return personService.findById(id);
    }

    @Override
    @RequestMapping("all")
    public HashSet<PersonDto> findAll() {
        return personService.findAll();
    }

    @Override
    @RequestMapping(params = "lastName")
    public HashSet<PersonDto> findByLastName(
            @RequestParam("lastName") String lastName) {
        return personService.findByLastName(lastName);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public void savePerson(@RequestBody PersonDto person) {
        personService.savePerson(person);
    }

}
