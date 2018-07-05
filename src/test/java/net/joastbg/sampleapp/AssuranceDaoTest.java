package net.joastbg.sampleapp;

import java.sql.Date;
import java.util.List;
import junit.framework.Assert;
import net.joastbg.sampleapp.dao.AssuranceDao;
import net.joastbg.sampleapp.entities.Assurance;
import net.joastbg.sampleapp.entities.AssuranceAuto;
import net.joastbg.sampleapp.entities.AssuranceHabitat;
import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.Echeances;
import net.joastbg.sampleapp.entities.PersonnePhysique;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AssuranceDaoTest {

    @Autowired

    SessionFactory sessionFactory;
    Assurance assurance;
    AssuranceDao assuranceDao;
    AssuranceAuto auto;
    AssuranceHabitat habitat;
    List<AssuranceAuto> lauto;
    List<AssuranceHabitat> lhabitat;
    List<Assurance> lassurance;
    Echeances echeance;

    @Before
    public void setUp() throws Exception {
        Date date = new Date(1992 - 1900, 02 - 1, 06);

        Client client = new Client();
        client.setIdClient(3);
        int idPhysique = client.getIdClient();
        PersonnePhysique physique = new PersonnePhysique();
        physique.setIdClient(idPhysique);
        physique.setNom("Roger");
        physique.setPrenom("Thomas");
        physique.setDateNaissance(date);
        
        //Question 6 ajout d'une echeance à une assurance
        Echeances echeance = new Echeances();
        
        echeance.setDateEmission("2016-02-06");
        echeance.setDateEmissionFacture("2016-06-12");
        echeance.setDatePaiement("2018-06-15");
        echeance.setPrix("150");
        echeance.setIdEcheance((long) 5);

        //Assurance habitation
        habitat = new AssuranceHabitat();
        habitat.setIdAssurance((long) 1);
        habitat.setClient(physique);
        habitat.setDateAnniversaire(new Date(2016 - 1900, 07 - 1, 06));
        habitat.setDatePrelevement(new Date(2016 - 1900, 07 - 1, 06));
        habitat.setDateSouscription(new Date(2016 - 1900, 07 - 1, 06));
        habitat.setAdresse("une adresse");
        habitat.setValeurConverture(1);
        habitat.setEcheances(echeance);
        System.out.println(habitat.toString());

        //Assurance auto
        auto = new AssuranceAuto();
        auto.setIdAssurance((long) 2);
        auto.setClient(physique);
        auto.setDateAnniversaire(new Date(2016 - 1900, 07 - 1, 06));
        auto.setDatePrelevement(new Date(2016 - 1900, 07 - 1, 06));
        auto.setDateSouscription(new Date(2016 - 1900, 07 - 1, 06));
        auto.setBonus_malus(0.5);
        auto.setImmatriculation("LS-347-AZ");
        auto.setEcheances(echeance);
        System.out.println(auto.toString());
    }

//Question 5 gestion des assurances
    @Test
    public void testPersist() {
        Long idhabitat = assuranceDao.persist(assurance);
        Assert.assertTrue((idhabitat != null));
        //assuranceDao.delete(assurance);
    }
    
    @Test
    public void testPersistAuto() {
        Long idAuto = assuranceDao.persistAuto(auto);
        Assert.assertTrue(idAuto != null);
        assuranceDao.delete(auto);
    }
    
    @Test
    public void testPersistHabitat() {
    	Long idHabitat = assuranceDao.persistHabitat(habitat);
        Assert.assertTrue(idHabitat != null);
        assuranceDao.delete(auto);
    }

    @Test
    public void testFindAll() {
        List<Assurance> assuranceFound = assuranceDao.findAll();
        Assert.assertNotNull(assuranceFound);
        Assert.assertEquals(assurance, assuranceFound.get(0));
        assuranceDao.delete(assurance);
    }

    @Test
    public void testFindAllAuto() {
        List<AssuranceAuto> assuranceFound = assuranceDao.findAllAuto();
        Assert.assertNotNull(assuranceFound);
    }

    @Test
    public void testFindAllHabitat() {
        List<AssuranceHabitat> assuranceFound = assuranceDao.findAllHabitat();
        Assert.assertNotNull(assuranceFound);
    }

    @Test
    public void testFind() {
        Long id = assuranceDao.persist(assurance);
        Assurance assuranceFound = assuranceDao.find(id);
        Assert.assertNotNull(assuranceFound);
        Assert.assertEquals(assurance, assuranceFound);
    }

    /**
     * Question 9 Résilier contrat a la date d'anniversaire
     */
    @Test
    public void testDeleteAnnDay() {
        int idAssurance = 0;
        AssuranceDao instance = new AssuranceDao();
        boolean ok = instance.DeleteAnnDay(idAssurance, 10);
        Session session = sessionFactory.getCurrentSession();
        List l = session.createQuery("select idAssurance from assurance where dateAnniversaire = CURDATE() and idAssurance = " + idAssurance + ";").list();
        System.out.println("Liste : " + l.toString() + "ok : " + ok);
        Assert.assertEquals(ok, !l.isEmpty());
    }
    
    
    /**
     * Question 6 ajout d'échéances
     */
    
    @Test
    public void testAddEcheance() {
        Long id = assuranceDao.addEcheance(echeance);
        Assert.assertTrue(id != null);
    }
    

}
