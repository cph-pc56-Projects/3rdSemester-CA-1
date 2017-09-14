/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;

import entity.Person;
import facade.Facade;

/**
 *
 * @author trez__000
 */
public class FacadeRunner {
    public static void main(String[] args) {
        Facade fc = new Facade();
        Person p = new Person();
        p.setFirstName("Vasile");
        p.setLastName("Moreno");
        fc.addPerson(p);
        System.out.println(fc.getPersons().toString());
    }
}
