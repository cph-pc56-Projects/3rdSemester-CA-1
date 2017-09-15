/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.CityInfo;

/**
 *
 * @author felesiah
 */
public class CityInfoMapper {
    public int Zip;
    public String city;

    public CityInfoMapper(CityInfo cityinfo) {
        this.Zip = cityinfo.getZipCode();
        this.city = cityinfo.getCity();
    }
   
}
