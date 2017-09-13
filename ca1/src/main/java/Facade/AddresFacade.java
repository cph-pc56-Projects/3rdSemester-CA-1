/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author marcofrydshou1
 */
public class AddresFacade {
    
    public AddresFacade() {
    }

    EntityManagerFactory emf;

    public AddresFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;

    }

    public EntityManager getentitymanager() {
        return emf.createEntityManager();
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
