/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author trez__000
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class InfoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;    
    private String email;
    
    @OneToMany(targetEntity = Phone.class)
    private List phonelist;
    
    @ManyToOne(targetEntity = Address.class)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public List getPhonelist() {
        return phonelist;
    }

    public void addPhone(Phone phone) {
        if (phonelist == null){
            this.phonelist = new ArrayList();
            this.phonelist.add(phone);
        }
        this.phonelist.add(phone);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
}
