/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;


import entity.Hobby;
import entity.Person;
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
        Person person = new Person();
        person.setFirstName("Sean");
        person.setLastName("Pen");
        person.setEmail("seab@pen.com");
        
        //fc.addPersonToHobby(person, 4);
        List<Hobby> hobbies = fc.getHobbies();
        HobbiesMapper hsm = new HobbiesMapper(hobbies);
        List<HobbyMapper> a = hsm.hobbies;
        for(HobbyMapper h: a){
            System.out.println(h.name);
        }
        
        List<Person> ppl = fc.getHobby(4).getPersons();
        for(Person p: ppl){
            System.out.println(p.getFirstName());
        }
        fc.addHobbyToPerson(fc.getHobby(4), 7);
        
    }
}
