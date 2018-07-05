package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.*;

import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssuranceDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long persist(Assurance assurance) {
    	Session session = sessionFactory.getCurrentSession();
        long id = (long) session.save(assurance);
        return id;
    	
    }
    
    public Long persistAuto(AssuranceAuto assurance) {
    	Session session = sessionFactory.getCurrentSession();
    	long id = (long) session.save(assurance);
        return id;
    	
    }
    
    public Long persistHabitat(AssuranceHabitat assurance) {
    	Session session = sessionFactory.getCurrentSession();
    	long id = (long) session.save(assurance);
        return id;
    	
    }

    public List<Assurance> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Assurance").list();
    }

    public List<AssuranceAuto> findAllAuto() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ASSURANCE_AUTO").list();
    }

    public List<AssuranceHabitat> findAllHabitat() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ASSURANCE_HABITATION").list();
    }

    public Assurance find(Long idAssurance) {
        Session session = sessionFactory.getCurrentSession();
        return (Assurance) session.load(Assurance.class, idAssurance);
    }

    public boolean DeleteAnnDay(int idAssurance, double prix) {
        boolean ok = false;
        Session session = sessionFactory.getCurrentSession();
        List l = session.createQuery("select idAssurance from assurance where dateAnniversaire = CURDATE() and idAssurance = " + idAssurance + ";").list();
        if (!l.isEmpty()) {
            Query query = session.createQuery("Insert into echeances(idassurance, prix, dateemission, datepaiement, dateemissionfacture) values( " + idAssurance + ", " + prix + ", CURDATE(), DURDATE(), CURDATE())");
            query.executeUpdate();
            ok = true;
        }
        return ok;
    }

    public void delete(Assurance assurance) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(assurance);
    }
    
    
    public long addEcheance(Echeances echeances) {
    	Session session = sessionFactory.getCurrentSession();
    	long id = (long) session.save(echeances);
        return id;
    }
}
