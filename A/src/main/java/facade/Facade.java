/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.CityInfo;
import entity.Address;
import entity.Company;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author trez__000
 */
public class Facade {

    EntityManagerFactory emf;
    
    public Facade(){
        emf = Persistence.createEntityManagerFactory("pu");
    }

    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.getTransaction().commit();
            return p;

        } finally {
            em.close();
        }
    }

    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return p;

        } finally {
            em.close();
        }
    }

    public Person deletePerson(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            Person p = em.find(Person.class, id);
            if (p == null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                return p;
            }

            return null;

        } finally {
            em.close();
        }

    }

    public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;

        } finally {

        }

    }
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons;
        try {
            Query qu = em.createQuery("SELECT p FROM Person p");
            persons = qu.getResultList();
            return persons;

        } finally {
            em.close();
        }
    }
    
    public Address getAddress(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Address a = em.find(Address.class, id);
            em.getTransaction().commit();
            return a;

        } finally {
            em.close();
        }

    }

    public Address addAddress(Address adr) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(adr);
            em.getTransaction().commit();
            return adr;

        } finally {
            em.close();
        }

    }

    public Address editAddress(Address ad) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ad);
            em.getTransaction().commit();
            return ad;

        } finally {
            em.close();
        }

    }

    public Address deleteAddress(Address adress) {
        EntityManager em = emf.createEntityManager();
        try {
            Address a = em.find(Address.class, adress.getAdress_id());
            if (a != null) {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
            }
            return a;

        } finally {
            em.close();
        }

    } 
    public CityInfo getCity(int zipCode){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            CityInfo c = em.find(CityInfo.class, zipCode);            
            em.getTransaction().commit();  
            return c;
        }
        finally{
            em.close();
        }
    }
    
     public List<CityInfo> getZipcodes() {
        EntityManager em = emf.createEntityManager();
        List<CityInfo> cityinfo;
        try {
            Query qu = em.createQuery("SELECT c FROM CityInfo c");
            cityinfo = qu.getResultList();
            return cityinfo;

        } finally {
            em.close();
        }
    }
    
    
     public List<Company> getcompanies() {
        EntityManager em = emf.createEntityManager();
        List<Company> company;
        try {
            Query qu = em.createQuery("SELECT c FROM Company c where c.NumEmpoyees >50");
            company = qu.getResultList();
            return company;

        } finally {
            em.close();
        }
    }
    
    
}
