/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.repository;

import java.util.stream.Stream;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ph.com.fsoft.temp.service.red.model.PersonColor;

/**
 *
 * @author warren.nocos
 */
@Repository
public interface PersonColorRepository extends PagingAndSortingRepository<PersonColor, Long> {

    Stream<PersonColor> findByColor(@Param("color") String color);

}
