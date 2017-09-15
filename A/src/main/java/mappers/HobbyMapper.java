/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.Hobby;
import entity.Person;
import java.util.List;


/**
 *
 * @author trez__000
 */
public class HobbyMapper {
    public int hobby_id;
    public String name;
    public String description;
    //public List<Person> persons;
    
    public HobbyMapper(Hobby hobby){
        this.hobby_id = hobby.getHobby_id();
        this.name = hobby.getName();
        this.description = hobby.getDescription();
        //this.persons = hobby.getPersons();
    }
}
