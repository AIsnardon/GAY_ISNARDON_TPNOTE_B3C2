/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp;

import net.joastbg.sampleapp.dao.SinistreDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import net.joastbg.sampleapp.entities.Sinistre;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Zzenl-Lsama
 */
public class SinistreDaoTest {
    
    @Autowired
    
    /**
     * Question 8 gestion des sinistres
     */
    
    Sinistre sinistre;
    Assurance assurance;
    
    public SinistreDaoTest() {
    }
    
    @Before
    public void setUp() {
    	 Date date = new Date(1992 - 1900, 02 - 1, 06);
    	 Date dateSinistre = new Date(2018 - 1900, 07 - 1, 05);
        sinistre = new Sinistre();
        
        PersonnePhysique physique = new PersonnePhysique();
        physique.setIdClient(2);
        physique.setNom("Roger");
        physique.setPrenom("Thomas");
        physique.setDateNaissance(date);
        
        assurance.setIdAssurance((long) 1);
        assurance.setDateAnniversaire(new Date(2016 - 1900, 07 - 1, 06));
        assurance.setDatePrelevement(new Date(2016 - 1900, 07 - 1, 06));
        assurance.setDateSouscription(new Date(2016 - 1900, 07 - 1, 06));
        
        sinistre.setIdSinistre((long) 1);
        sinistre.setAssurance(assurance);
        sinistre.setClient(physique);
        sinistre.setDate(dateSinistre);
        sinistre.setDescription("Le tp d'orm");
        sinistre.setTitre("Aie");
    }
    
    /**
     * Test of persist method, of class SinistreDao.
     */
    @Test
    public void testPersist() {
        SinistreDao instance = new SinistreDao();
        String result = instance.persist(sinistre);
        System.out.println(result);
    }

    /**
     * Test of find method, of class SinistreDao.
     */
    @Test
    public void testFind() {
        SinistreDao instance = new SinistreDao();
        long idsinistre = sinistre.getIdSinistre();
        Sinistre result = instance.find((int)idsinistre);
        System.out.println(result);
    }

    /**
     * Test of delete method, of class SinistreDao.
     */
    @Test
    public void testDelete() {
        Sinistre sinistre = null;
        SinistreDao instance = new SinistreDao();
        instance.delete(sinistre);
    }
    
}
