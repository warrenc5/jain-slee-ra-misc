/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author wozza
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
    @JoinTable(name="Person_Car",
        joinColumns={@JoinColumn(name="person_Id")},
        inverseJoinColumns={@JoinColumn(name="car_Id")})
    protected List<Car> Cars = new ArrayList<Car>();
    protected String name;

    public Person() {
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the value of Cars
     *
     * @return the value of Cars
     */
    public List<Car> getCars() {
        return Cars;
    }

    /**
     * Set the value of Cars
     *
     * @param Cars new value of Cars
     */
    public void setCars(List<Car> Cars) {
        this.Cars = Cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person))
            return false;
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "test.jpa.Person[id=" + id + "]";
    }

}
