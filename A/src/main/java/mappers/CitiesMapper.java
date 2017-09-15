/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.CityInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felesiah
 */
public class CitiesMapper {
     public List<CityInfoMapper> cities = new ArrayList();
    
    public CitiesMapper(List<CityInfo> cities){
        for (CityInfo c: cities) {
            this.cities.add(new CityInfoMapper(c));
        }
        
    }
    
}
