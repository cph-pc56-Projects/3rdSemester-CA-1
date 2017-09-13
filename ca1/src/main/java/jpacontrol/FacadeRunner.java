/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import Facade.Facade;
import entity.Person;
import javax.persistence.Persistence;

/**
 *
 * @author trez__000
 */
public class FacadeRunner {
    public static void main(String[] args) {
        Facade pf = new Facade();
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("ca1"));
        
        Person person = new Person();
        person.setFirstName("Mike");
        person.setLastName("Burner");
        person.setEmail("mike@burner.io");
        
        pf.addPerson(person);
        
        System.out.println(pf.getPerson(2).getFirstName());
        System.out.println(pf.getPersons());
        
    }
}
