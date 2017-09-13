/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Address;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author marcofrydshou1
 */
public class Facade {
    
     public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Facade() {

    }

    EntityManagerFactory emf;

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntity() {
        return emf.createEntityManager();
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
    
    public Person addPerson(Person p){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
            
        }finally{
            
        }
        
    }
    
    public List<Person>getPersons(){
        EntityManager em = emf.createEntityManager();
        try{
            Query qu = em.createNamedQuery("");
            return qu.getResultList();
            
        }finally{
            em.close();
        }
                
                
    }
    
    public List<Person> getPersonsByZip(int zipCode){
        EntityManager em = emf.createEntityManager();
        
        try{
            Query qu = em.createNamedQuery("");
            qu.setParameter(zipCode, zipCode);
            return qu.getResultList();
            
        }finally{
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
    
    
    
}
