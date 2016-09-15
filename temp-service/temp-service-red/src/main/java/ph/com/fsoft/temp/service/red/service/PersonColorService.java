/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.service;

import java.util.HashSet;
import ph.com.fsoft.temp.service.red.model.dto.PersonColorDto;

/**
 * Service interface
 *
 * @author warren.nocos
 */
public interface PersonColorService {

    HashSet<PersonColorDto> findByColor(String color);

    HashSet<PersonColorDto> findAll();

    void savePersonColor(long personId, String color);

}
