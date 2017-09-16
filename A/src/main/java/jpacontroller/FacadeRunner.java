
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;


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
        
        /*
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
       */
        Phone phone1 = new Phone();
        phone1.setNumber(50312096);
        phone1.setDescription("Private mobile number");
        
        Phone phone2 = new Phone();
        phone2.setNumber(0041234);
        phone2.setDescription("Assistant");
        
        
        Person person;
        person = fc.getPerson(2);
        person.addPhone(phone2);
        fc.editPerson(person);
    }
}
