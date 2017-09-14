/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trez__000
 */
public class PersonsMapper {
    public List<PersonMapper> persons = new ArrayList();
    
    public PersonsMapper(List<Person> persons){
        for (Person p: persons) {
            this.persons.add(new PersonMapper(p));
        }
        
    }
    
}
