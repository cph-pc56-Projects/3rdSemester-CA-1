/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author trez__000
 */
@Entity
public class CityInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int Zip;
    private String city;

    

    public int getZip() {
        return Zip;
    }

    public void setZipCode(int Zip) {
        this.Zip = Zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
