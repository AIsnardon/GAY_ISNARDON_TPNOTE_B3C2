/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp;

import java.sql.Date;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ContactDao;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Contact;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Zzenl-Lsama
 */
public class ContactDaoTest {
    
    @Autowired
    ContactDao contactDao;
    Contact contact;
    
    public ContactDaoTest() {
    }
    
    @Before
    public void setUp() {
        contact = new Contact();
        contact.setType("mail");
        contact.setValeur("unmail@mail.com");
        Date date = new Date(1992-1900,02-1,06);
    	
        Client client = new Client();
    	client.setIdClient(3);
    	int idPhysique = client.getIdClient();
        PersonnePhysique physique = new PersonnePhysique();
    	physique.setIdClient(idPhysique);
    	physique.setNom("Roger");
    	physique.setPrenom("Thomas");
    	physique.setDateNaissance(date);
        
        contact.setClient(physique);
    }


    /**
     * Question 4 gestion des contacts
     */
    @Test
    public void testPersist() {
        String id = contactDao.persist(contact);
        Assert.assertTrue(id != null);
        contactDao.delete(contact);
    }

    /**
     * Test of find method, of class ContactDao.
     */
    @Test
    public void testFind() {
        String id = contactDao.persist(contact);
        Contact contactFound = contactDao.find(id);
        Assert.assertNotNull(contactFound);
        Assert.assertEquals(contact,contactFound);
        contactDao.delete(contact);
    }

    
}
