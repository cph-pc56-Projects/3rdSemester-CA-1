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
    
    private int cityInfo_id;
    private int ZipCode;
    private String city;

    public int getCityInfo_id() {
        return cityInfo_id;
    }

    public void setCityInfo_id(int cityInfo_id) {
        this.cityInfo_id = cityInfo_id;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int ZipCode) {
        this.ZipCode = ZipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
