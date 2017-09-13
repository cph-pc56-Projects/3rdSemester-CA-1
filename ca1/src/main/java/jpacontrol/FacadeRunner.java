/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import Facade.PersonFacade;
import entity.Person;
import javax.persistence.Persistence;

/**
 *
 * @author trez__000
 */
public class FacadeRunner {
    public static void main(String[] args) {
        PersonFacade pf = new PersonFacade();
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("ca1"));
        
        Person person = new Person();
        person.setFirstName("Mike");
        person.setLastName("Burner");
        person.setEmail("mike@burner.io");
        
        pf.addperson(person);
        
    }
}
