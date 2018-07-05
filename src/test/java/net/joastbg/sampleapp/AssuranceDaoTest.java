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

        habitat = new AssuranceHabitat();
        habitat.setIdAssurance((long) 1);
        habitat.setClient(physique);
        habitat.setDateAnniversaire(new Date(2016 - 1900, 07 - 1, 06));
        habitat.setDatePrelevement(new Date(2016 - 1900, 07 - 1, 06));
        habitat.setDateSouscription(new Date(2016 - 1900, 07 - 1, 06));
        habitat.setAdresse("une adresse");
        habitat.setValeurConverture(1);
        habitat.setEcheances(null);
        System.out.println(habitat.toString());

        auto = new AssuranceAuto();
        auto.setIdAssurance((long) 2);
        auto.setClient(physique);
        auto.setDateAnniversaire(new Date(2016 - 1900, 07 - 1, 06));
        auto.setDatePrelevement(new Date(2016 - 1900, 07 - 1, 06));
        auto.setDateSouscription(new Date(2016 - 1900, 07 - 1, 06));
        auto.setBonus_malus(0.5);
        auto.setImmatriculation("LS-347-AZ");
        System.out.println(auto.toString());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPersist() {
        Long idhabitat = assuranceDao.persist(assurance);
        Long idauto = assuranceDao.persist(assurance);
        Assert.assertTrue((idhabitat != null && idauto != null));
        assuranceDao.delete(assurance);
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
     * Test of DeleteAnnDay method, of class AssuranceDao.
     */
    @Test
    public void testDeleteAnnDay() {
        System.out.println("DeleteAnnDay");
        int idAssurance = 0;
        AssuranceDao instance = new AssuranceDao();
        boolean ok = instance.DeleteAnnDay(idAssurance, 10);
        Session session = sessionFactory.getCurrentSession();
        List l = session.createQuery("select idAssurance from assurance where dateAnniversaire = CURDATE() and idAssurance = " + idAssurance + ";").list();
        System.out.println("Liste : " + l.toString() + "ok : " + ok);
        Assert.assertEquals(ok, !l.isEmpty());
    }

}
