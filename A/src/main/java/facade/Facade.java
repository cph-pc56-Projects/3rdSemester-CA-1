/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
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

    public Facade() {
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
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                return p;
            }
        return null;
        }
        
        finally {
            em.close();
        }

    }

    public void addPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();            

        } finally {

        }
    }

    public void addHobbyToPerson(Hobby hobby, int personId) {
        EntityManager em = emf.createEntityManager();
        Person person = getPerson(personId);
        person.addHobby(hobby);
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
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
    
    public List<Person> getPersonsByZip(int zip){        
        List<Person> pZip = new ArrayList();
        List<Person> persons = getPersons();
        for (Person p: persons){
            if(p.getAddress().getCityinfo().getZip() == zip){
                pZip.add(p);
            }
            else {
                return null;
            }
        }
        return pZip;
    }

    public List<Company> getCompanies() {
        EntityManager em = emf.createEntityManager();
        List<Company> companies;
        try {
            Query qu = em.createQuery("SELECT c FROM Company c");
            companies = qu.getResultList();
            return companies;
        } finally {
            em.close();
        }
    }

    public List<Hobby> getHobbies() {
        EntityManager em = emf.createEntityManager();
        List<Hobby> hobbies;
        try {
            Query qu = em.createQuery("SELECT h FROM Hobby h");
            hobbies = qu.getResultList();
            return hobbies;
        } finally {
            em.close();
        }
    }

    public Hobby getHobby(int hobbyId) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby;
        try {
            em.getTransaction().begin();
            hobby = em.find(Hobby.class, hobbyId);
            em.getTransaction().commit();
            return hobby;
        } finally {
            em.close();
        }
    }

    public void addHobby(String name, String description) {
        EntityManager em = emf.createEntityManager();
        Hobby h = new Hobby();
        h.setName(name);
        h.setDescription(description);
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addPersonToHobby(Person p, int hobbyId) {
        EntityManager em = emf.createEntityManager();
        Hobby hobby = getHobby(hobbyId);
        hobby.addPerson(p);
        try {
            em.getTransaction().begin();
            em.merge(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CityInfo getCity(int zipCode) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CityInfo c = em.find(CityInfo.class, zipCode);
            em.getTransaction().commit();
            return c;
        } finally {
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
    
    public Address getAddressById(int id){
        EntityManager em = emf.createEntityManager();
        Address address;
        try{
            em.getTransaction().begin();
            address = em.find(Address.class, id);
            em.getTransaction().commit();
            return address;
        }
        finally {
            em.close();
        }
    }
    
    public void addCityInfoToAddress(CityInfo city, int addressId){
        EntityManager em = emf.createEntityManager();
        try{
            Address address = getAddressById(addressId);
            address.setCityinfo(city);
            em.getTransaction().begin();
            em.merge(address);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}
