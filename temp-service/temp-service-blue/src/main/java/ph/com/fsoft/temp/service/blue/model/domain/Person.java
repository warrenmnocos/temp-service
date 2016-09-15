/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ph.com.fsoft.temp.service.blue.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 * Simple domain model, person :)
 *
 * @author warren.nocos
 */
@Entity
@Table(name = "person")
public class Person
        implements Comparable<Person>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false,
            name = "id")
    @TableGenerator(initialValue = 1,
            name = "temp_service_blue_id_generator",
            pkColumnName = "table_name",
            pkColumnValue = "temp_service_blue",
            table = "id_generator",
            valueColumnName = "available_id")
    @GeneratedValue(generator = "temp_service_blue_id_generator",
            strategy = GenerationType.TABLE)
    protected long id;

    @Column(name = "first_name",
            nullable = false)
    @NotNull
    protected String firstName;

    @Column(name = "middle_name",
            nullable = false)
    @NotNull
    protected String middleName;

    @Column(name = "last_name",
            nullable = false)
    @NotNull
    protected String lastName;

    public Person() {
        firstName = middleName = lastName = "";
    }

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Long.compare(id, otherPerson.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.middleName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
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
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.middleName, other.middleName)) {
            return false;
        }
        return Objects.equals(this.lastName, other.lastName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Blue{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + '}';
    }

}
