/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.service;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.com.fsoft.temp.service.red.model.PersonColor;
import ph.com.fsoft.temp.service.red.model.dto.PersonColorDto;
import ph.com.fsoft.temp.service.red.model.dto.PersonDto;
import ph.com.fsoft.temp.service.red.repository.PersonColorRepository;

/**
 * Service interface implementation
 *
 * @author warren.nocos
 */
@Service
@Transactional(readOnly = true)
public class PersonColorServiceImpl implements PersonColorService {

    protected final PersonColorRepository personColorRepository;

    protected final PersonService personService;

    @Inject
    public PersonColorServiceImpl(
            PersonColorRepository personColorRepository,
            PersonService personService) {
        this.personColorRepository = personColorRepository;
        this.personService = personService;
    }

    @Override
    public HashSet<PersonColorDto> findAll() {
        return StreamSupport.stream(personColorRepository.findAll().spliterator(), false)
                .map(personColor -> {
                    PersonDto personDto = personService.findById(personColor.getId())
                            .orElseThrow(() -> new RuntimeException("Person associated with provided id is not found."));
                    return new PersonColorDto(personDto, personColor.getColor());
                })
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public HashSet<PersonColorDto> findByColor(String color) {
        return personColorRepository.findByColor(color)
                .map(personColor -> {
                    PersonDto personDto = personService.findById(personColor.getId())
                            .orElseThrow(() -> new RuntimeException("Person associated with provided id is not found."));
                    return new PersonColorDto(personDto, personColor.getColor());
                })
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    @Transactional
    public void savePersonColor(long personId, String color) {
        if (personService.findById(personId).isPresent()) {
            personColorRepository.save(new PersonColor(personId, color));
        } else {
            throw new RuntimeException("Person associated with provided id is not found.");
        }
    }

}
