/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trez__000
 */
public class PersonMapper {
    public String fName;
    public String lName;
    public String email;
    public Address address;
    public List<Phone> phoneList;
    public List<String> hobbies;
    
    
    public PersonMapper(Person person, boolean addHobby){
        this.fName = person.getFirstName();
        this.lName = person.getLastName();
        this.email = person.getEmail();
        this.address = person.getAddress();
        phoneList = new ArrayList();
        phoneList = person.getPhonelist();
        if (addHobby){
            hobbies = new ArrayList();
            for (Hobby h: person.getHobbies()){
                hobbies.add(h.getName());
            }
        }
    }
    
    
    
}
