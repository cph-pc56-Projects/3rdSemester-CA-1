
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class Person extends InfoEntity implements Serializable {      
    
    private String firstName;
    private String lastName;
    
    
    @ManyToMany(targetEntity = Hobby.class)
    private List<Hobby> hobbies;

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void addHobby(Hobby hobby) {
        if(hobbies == null){
            hobbies = new ArrayList();
        }
        hobbies.add(hobby);
    }
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
