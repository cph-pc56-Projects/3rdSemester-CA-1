
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.Facade;
import java.util.ArrayList;
import java.util.List;
import mappers.HobbiesMapper;
import mappers.HobbyMapper;

/**
 *
 * @author trez__000
 */
public class FacadeRunner {

    public static void main(String[] args) {
        Facade fc = new Facade();
        
        Phone phone1 = new Phone();
        phone1.setNumber(9100000);
        phone1.setDescription("Private number");

        Address address = new Address();
        address.setStreet("NoraStreet");
        address.setAdditionalInfo("where the magic happens");
        address.setCityinfo(fc.getCity(1710));

        
        Person p = new Person();
        p.setFirstName("Garry");
        p.setLastName("Pott");
        p.setEmail("garry@potter.com");
        fc.addPerson(p);
        p.addPhone(phone1);
        fc.editPerson(p);
        
        

    }
}

