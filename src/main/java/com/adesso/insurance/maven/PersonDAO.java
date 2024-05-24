package com.adesso.insurance.maven;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPU");

    public void createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public Person readPerson(String string) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, string);
        em.close();
        return person;
    }

    public void updatePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePerson(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p").getResultList();
        em.close();
        return persons;
    }

		
	}



