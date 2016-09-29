/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.model.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ph.com.fsoft.temp.service.blue.model.PersonDto;

/**
 *
 * @author warren.nocos
 */
@XmlType
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonColorDto
        implements Comparable<PersonColorDto>, Serializable {

    @XmlElement
    protected PersonDto personDto;

    @XmlElement
    protected String color;

    public PersonColorDto() {
        color = "";
    }

    public PersonColorDto(PersonDto personDto, String color) {
        this.personDto = personDto;
        this.color = color;
    }

    @Override
    public int compareTo(PersonColorDto otherPersonColorDto) {
        return personDto.compareTo(otherPersonColorDto.personDto);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.personDto);
        hash = 47 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonColorDto other = (PersonColorDto) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return Objects.equals(this.personDto, other.personDto);
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PersonColorDto{" + "personDto=" + personDto + ", color=" + color + '}';
    }

}
