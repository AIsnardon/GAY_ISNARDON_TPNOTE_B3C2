/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp;

import net.joastbg.sampleapp.dao.SinistreDao;
import net.joastbg.sampleapp.entities.Sinistre;
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
public class SinistreDaoTest {
    
    @Autowired
    
    Sinistre sinistre;
    
    public SinistreDaoTest() {
    }
    
    @Before
    public void setUp() {
        sinistre = new Sinistre();
    }
    
    /**
     * Test of persist method, of class SinistreDao.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        Sinistre sinistre = null;
        SinistreDao instance = new SinistreDao();
        String expResult = "";
        String result = instance.persist(sinistre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class SinistreDao.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String idsinistre = "";
        SinistreDao instance = new SinistreDao();
        Sinistre expResult = null;
        Sinistre result = instance.find(idsinistre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SinistreDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Sinistre sinistre = null;
        SinistreDao instance = new SinistreDao();
        instance.delete(sinistre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
