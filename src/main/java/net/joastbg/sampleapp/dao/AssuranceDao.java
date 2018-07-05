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

	    public Long persist(Assurance assurance){
	        Session session = sessionFactory.getCurrentSession();
	        Long returnID = (Long) session.save(assurance);
	        return returnID;
	    }

	    public List<Assurance> findAll(){
	        Session session = sessionFactory.getCurrentSession();
	        return  session.createQuery("from Assurance").list();
	    }
	    
	    public List<AssuranceAuto> findAllAuto(){
	        Session session = sessionFactory.getCurrentSession();
	        return  session.createQuery("from ASSURANCE_AUTO").list();
	    }
	    
	    public List<AssuranceHabitat> findAllHabitat(){
	        Session session = sessionFactory.getCurrentSession();
	        return  session.createQuery("from ASSURANCE_HABITATION").list();
	    }
	    
	    public Assurance find(int idAssurance){
	        Session session= sessionFactory.getCurrentSession();
	        return (Assurance) session.load(Assurance.class, idAssurance);
	    }
            
            public void DeleteAnnDay(int idAssurance)
            {
                Session session= sessionFactory.getCurrentSession();
	        Query query = session.createQuery("Delete Cascade Assurance where idAssurance = " + idAssurance + " and dateAnniversaire = CURDATE()");
                query.executeUpdate();
            }
}
