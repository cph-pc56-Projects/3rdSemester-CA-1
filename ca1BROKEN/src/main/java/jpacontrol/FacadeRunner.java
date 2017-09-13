/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import Facade.Facade;
import javax.persistence.Persistence;

/**
 *
 * @author trez__000
 */
public class FacadeRunner {
    public static void main(String[] args) {
        Facade pf = new Facade();
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("ca1"));
        
        
        
        System.out.println(pf.getCity(1710).getCity());
        System.out.println(pf.getPersons().get(0).getFirstName());
        
    }
}
