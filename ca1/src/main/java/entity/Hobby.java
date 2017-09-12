/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author trez__000
 */
@Entity
public class Hobby implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int hobby_id;
    private String name;
    private String description;
    
    @ManyToMany(targetEntity = Person.class)
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPerson(Person person) {
        
        if(persons == null){
            persons = new ArrayList();
        }

        persons.add(person);
        
    }

    

    public int getHobby_id() {
        return hobby_id;
    }

    public void setHobby_id(int hobby_id) {
        this.hobby_id = hobby_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
