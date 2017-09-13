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

    public EntityManager getentity() {
        return emf.createEntityManager();
    }

    public Person getperson(int id) {
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

    public Person editperson(Person p) {
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

    public Person deleteperson(int id) {
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
    
    public Person addperson(Person p){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
            
        }finally{
            
        }
        
    }
    
    public List<Person>getpersons(){
        EntityManager em = emf.createEntityManager();
        try{
            Query qu = em.createNamedQuery("");
            return qu.getResultList();
            
        }finally{
            em.close();
        }
                
                
    }
    
    public List<Person> getpersonsbyid(int zipCode){
        EntityManager em = emf.createEntityManager();
        
        try{
            Query qu = em.createNamedQuery("");
            qu.setParameter(zipCode, zipCode);
            return qu.getResultList();
            
        }finally{
            em.close();
        }
        
    }
    
    public Address getadress(int id) {
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

    public Address adadress(Address adr) {
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

    public Address editadress(Address ad) {
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

    public Address deleteadress(Address adress) {
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
