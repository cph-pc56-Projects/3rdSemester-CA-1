/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;


import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author trez__000
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        Phone phone1 = new Phone();
        phone1.setNumber(50312096);
        phone1.setDescription("Private mobile number");
        
        Phone phone2 = new Phone();
        phone2.setNumber(12121212);
        phone2.setDescription("Home Office");
        
        List<Phone> phoneList = new ArrayList();
        phoneList.add(phone1);
        phoneList.add(phone2);
        
        
        InfoEntity ie = new InfoEntity();
        ie.setEmail("ptc@gmail.com");
        
        
        CityInfo cityinfo = new CityInfo();
        cityinfo.setCity("Copenhagen");
        cityinfo.setZip(1720);
        
        
        Address address = new Address();
        address.setStreet("Sonder Boulevard");
        address.setAdditionalInfo("The place where the magic happens");
        address.setCityinfo(cityinfo);
        
        ie.setAddress(address);
        
        
        Person person = new Person();
        person.setFirstName("Petru");
        person.setLastName("Catana");
        person.setEmail("catanapetru@gmail.com");
        Address addressP = new Address();
        addressP.setStreet("Moon");
        addressP.setAdditionalInfo("300,000 km distance from Earth");
        person.setAddress(addressP);
        Phone phoneP = new Phone();
        phoneP.setNumber(111111);
        phoneP.setDescription("Emergency Number");
        List<Phone> phonesP = new ArrayList();
        phonesP.add(phoneP);
       
        
        
        Company c = new Company();
        c.setName("Tesla");
        c.setDescription("Energy Company");
        c.setCvr(223321);
        c.setNumEmpoyees(250000);
        c.setMarketValue(44000000);
        c.setEmail("tesla@tesla.com");
        Address ac = new Address();
        ac.setStreet("Sun Avenue");
        ac.setAdditionalInfo("Close to SpaceX HQ");
        c.setAddress(ac);
        Phone cp = new Phone();
        cp.setDescription("Official Line");
        cp.setNumber(2233323);
        List<Phone> cps = new ArrayList();
        
        
        Hobby hobby = new Hobby();
        hobby.setName("Reading");
        hobby.setDescription("SCI-FI");        
        hobby.addPerson(person);
        person.addHobby(hobby);
        
        
        em.getTransaction().begin();
        em.persist(person);
        em.persist(addressP);
        em.persist(phoneP);
        em.persist(hobby);
        em.persist(c);
        em.persist(ac);
        em.persist(cp);
        em.getTransaction().commit();
        em.close();
    }
}

