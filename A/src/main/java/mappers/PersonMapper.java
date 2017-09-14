/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.Person;

/**
 *
 * @author trez__000
 */
public class PersonMapper {
    public String fName;
    public String lName;
    
    public PersonMapper(Person person){
        this.fName = person.getFirstName();
        this.lName = person.getLastName();
    }
    
}
