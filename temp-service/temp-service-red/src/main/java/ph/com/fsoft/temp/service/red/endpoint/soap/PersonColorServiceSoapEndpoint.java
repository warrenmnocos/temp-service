/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.endpoint.soap;

import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ph.com.fsoft.temp.service.red.model.dto.PersonColorDto;
import ph.com.fsoft.temp.service.red.service.PersonColorService;

/**
 * Rest endpoint
 *
 * @author warren.nocos
 */
@Service
@WebService
public class PersonColorServiceSoapEndpoint implements PersonColorService {

    protected final PersonColorService personColorService;

    @Inject
    public PersonColorServiceSoapEndpoint(
            @Named("personColorServiceImpl") PersonColorService personColorService) {
        this.personColorService = personColorService;
    }

    @Override
    @WebMethod
    public HashSet<PersonColorDto> findByColor(@RequestParam("color") String color) {
        return personColorService.findByColor(color);
    }

    @Override
    @WebMethod
    public HashSet<PersonColorDto> findAll() {
        return personColorService.findAll();
    }

    @Override
    @WebMethod
    public void savePersonColor(long personId, String color) {
        personColorService.savePersonColor(personId, color);
    }

}
