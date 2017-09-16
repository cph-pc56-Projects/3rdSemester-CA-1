
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
        phone1.setNumber(50312096);
        phone1.setDescription("Private mobile number");

        Address address = new Address();
        address.setStreet("Istegade");
        address.setAdditionalInfo("The place where the magic happens");
        address.setCityinfo(fc.getCity(1710));

        Person person;
        person = fc.getPerson(2);
        person.addPhone(phone1);
        person.setAddress(address);
        System.out.println(person.getAddress().getCityinfo().getZip());

        
        List<Person> persons = fc.getPersons();
        for (Person p : persons) {
            if (p.getAddress().getCityinfo().getZip() == 1710) {
                System.out.println(p.getFirstName());
            } else {
                System.out.println("No persons found");
            }
        }

    }
}

