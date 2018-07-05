package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Client;
import net.joastbg.sampleapp.entities.CompteBancaire;
import net.joastbg.sampleapp.entities.PersonneMorale;
import net.joastbg.sampleapp.entities.PersonnePhysique;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long persist(Client client){
        Session session = sessionFactory.getCurrentSession();
        long id = client.getIdClient();
        session.createQuery("insert into Client(idClient)" + "SELECT idClient from Client");
        return id;
    }
    
    public Long persistPhysique(PersonnePhysique client){
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }
    
    public Long persistMorale(PersonneMorale client){
        Session session = sessionFactory.getCurrentSession();
        Long returnID = (Long) session.save(client);
        return returnID;
    }
    
    public void deletePhysique(PersonnePhysique client){
        Session session= sessionFactory.getCurrentSession();
        session.delete(client);
    }
    
    public void deleteMorale(PersonneMorale client){
        Session session= sessionFactory.getCurrentSession();
        session.delete(client);
    }

    public List<Client> findAll(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Client").list();
    }
    
    public List<PersonnePhysique> findAllPhysique(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Personne_physique").list();
    }
    
    public List<PersonneMorale> findAllMoral(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Personne_morale").list();
    }
}
