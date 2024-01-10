package com.demo.entitybean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class LibraryPersistentBean
 */
@Stateless
@LocalBean
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    /**
     * Default constructor. 
     */
    public LibraryPersistentBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName="EjbComponentPU")
    private EntityManager entityManager;         

    public void addBook(Book book) {
       entityManager.persist(book);
    }    

    public List<Book> getBooks() {
       return entityManager.createQuery("From Book").getResultList();
    }
 }