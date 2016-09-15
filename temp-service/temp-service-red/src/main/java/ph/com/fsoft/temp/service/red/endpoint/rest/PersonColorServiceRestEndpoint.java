/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.endpoint.rest;

import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ph.com.fsoft.temp.service.red.model.dto.PersonColorDto;
import ph.com.fsoft.temp.service.red.service.PersonColorService;

/**
 * Rest endpoint
 *
 * @author warren.nocos
 */
@RestController
@RequestMapping("api/rest/person/color")
public class PersonColorServiceRestEndpoint implements PersonColorService {

    protected final PersonColorService personColorService;

    @Inject
    public PersonColorServiceRestEndpoint(
            @Named("personColorServiceImpl") PersonColorService personColorService) {
        this.personColorService = personColorService;
    }

    @Override
    @RequestMapping("all")
    public HashSet<PersonColorDto> findAll() {
        return personColorService.findAll();
    }

    @Override
    @RequestMapping(params = "color")
    public HashSet<PersonColorDto> findByColor(@RequestParam("color") String color) {
        return personColorService.findByColor(color);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,
            params = {"personId", "color"})
    public void savePersonColor(long personId, String color) {
        personColorService.savePersonColor(personId, color);
    }

}
