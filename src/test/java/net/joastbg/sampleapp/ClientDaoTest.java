package net.joastbg.sampleapp;

import junit.framework.Assert;
import net.joastbg.sampleapp.dao.ClientDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/config/BeanLocations.xml")
public class ClientDaoTest {

    @Autowired
    ClientDao clientDao;
    Client client;
    PersonnePhysique physique;
    PersonneMorale morale;

    @SuppressWarnings("deprecation")
	@Before
    public void setUp() {
    	Date date = new Date(1992-1900,02-1,06);
    	
    	client = new Client();
    	client.setIdClient(3);
    	int idPhysique = client.getIdClient();
    	physique = new PersonnePhysique();
    	physique.setIdClient(idPhysique);
    	physique.setNom("Roger");
    	physique.setPrenom("Thomas");
    	physique.setDateNaissance(date);
    	System.out.println(physique.toString());
    	
    	
    	client = new Client();
    	client.setIdClient(4);
    	int idMoral = client.getIdClient();
    	morale = new PersonneMorale();
    	morale.setIdClient(idMoral);
    	morale.setNom("Company of Doom");
    	morale.setSiren("025414782");
    	System.out.println(morale.toString());
    	
    }

    @Test
    public void testPersist(){
    	 Long id = clientDao.persist(client);
    	 Assert.assertTrue(id != null);
    } 
    
    @Test
    public void testPersistPhysique(){
    	int idPhysique = clientDao.persistPhysique(physique);
    	//Assert.assertTrue(idPhysique != null);
    	//clientDao.deletePhysique(physique);
    }
    
    @Test
    public void testPersistMorale(){
    	int idMoral = clientDao.persistMorale(morale);
    	//Assert.assertTrue(idMoral != null);
    	//clientDao.deleteMorale(morale);
    }



}
