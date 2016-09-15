/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.service;

import java.util.HashSet;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ph.com.fsoft.temp.service.red.model.dto.PersonDto;

/**
 * Service implementation. Use {@link Transactional#readOnly() } set to true,
 * for read access.
 *
 * @author warren.nocos
 */
@Service
public class PersonServiceImpl implements PersonService {

    protected final RestTemplate restTemplate;

    /**
     * I prefer {@link Inject} because it is the standard way of injecting
     * dependencies. ALso, please prefer CONSTRUCTOR INJECTION, because it
     * provides a contract that this object will not be created unless
     * dependencies are provided :).
     *
     * @param restTemplate
     */
    @Inject
    public PersonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<PersonDto> findById(long id) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("http://blue/blue/api/rest/person")
                .queryParam("id", id);
        return Optional.ofNullable(restTemplate.getForObject(uri.build().toUri(), PersonDto.class));
    }

    @Override
    public HashSet<PersonDto> findByLastName(String firstName) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("http://blue/blue/api/rest/person")
                .queryParam("firstName", firstName);
        return restTemplate.getForObject(uri.build().toUri(), HashSet.class);
    }

}
