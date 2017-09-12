/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author marcofrydshou1
 */
public class PersonFacade {
    
     public PersonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PersonFacade() {

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
            em.getTransaction();
            Person p = em.find(Person.class, id);
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
    
    
    
}
