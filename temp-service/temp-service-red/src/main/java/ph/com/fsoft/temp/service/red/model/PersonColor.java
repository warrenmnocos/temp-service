/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.red.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Simple domain, just to associate person to his/her favorite color, not that
 * complicated :).
 *
 * @author warren.nocos
 */
@Entity
@Table(name = "person_color")
public class PersonColor
        implements Comparable<PersonColor>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false,
            name = "id")
    @TableGenerator(initialValue = 1,
            name = "temp_service_red_id_generator",
            pkColumnName = "table_name",
            pkColumnValue = "temp_service_red",
            table = "id_generator",
            valueColumnName = "available_id")
    @GeneratedValue(generator = "temp_service_red_id_generator",
            strategy = GenerationType.TABLE)
    protected long id;

    @Column(name = "person_id",
            nullable = false,
            unique = true)
    protected long personId;

    @Column(name = "color",
            nullable = false)
    protected String color;

    public PersonColor() {
        color = "";
    }

    public PersonColor(long personId, String color) {
        this.personId = personId;
        this.color = color;
    }

    @Override
    public int compareTo(PersonColor otherPersonColor) {
        return Long.compare(id, otherPersonColor.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + (int) (this.personId ^ (this.personId >>> 32));
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
        final PersonColor other = (PersonColor) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.personId == other.personId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PersonColor{" + "id=" + id + ", personId=" + personId + ", color=" + color + '}';
    }

}
