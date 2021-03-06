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
public class Person extends InfoEntity implements Serializable {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }
        
    

    @ManyToMany(targetEntity = Hobby.class)
    private List<Hobby> hobbies;

 

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void addHobby(Hobby hobby) {
        if (hobbies == null) {
            hobbies = new ArrayList();
        }
        hobbies.add(hobby);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", hobbies=" + hobbies + '}';
    }

}
