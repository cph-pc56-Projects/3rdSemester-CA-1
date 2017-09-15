/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entity.Hobby;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trez__000
 */
public class HobbiesMapper {
    public List<HobbyMapper> hobbies = new ArrayList();
    
    public HobbiesMapper(List<Hobby> hobbies){
        for (Hobby h: hobbies){
            this.hobbies.add(new HobbyMapper(h));
        }
    }
}
