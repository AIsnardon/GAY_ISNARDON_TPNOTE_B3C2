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

import java.util.Date;
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
    
    public int persistPhysique(PersonnePhysique client){
        Session session = sessionFactory.getCurrentSession();
        int returnID =client.getIdClient();
        
        String sql = "insert into PERSONNE_PHYSIQUE(idClient,nom,prenom,dateNaissance)" + 
        "SELECT idClient,nom,prenom,dateNaissance from PERSONNE_PHYSIQUE";
        
        session.createQuery(sql);
        
        return returnID;
    }
    
    public int persistMorale(PersonneMorale client){
        Session session = sessionFactory.getCurrentSession();
        
        int returnID =client.getIdClient();
        String nom = client.getNom();
        String siren = client.getSiren();
        
        String sql = "insert into PERSONNE_MORALE(idClient,nom,siren) " + 
        "SELECT idClient, nom,siren from PERSONNE_MORALE";
        
        System.out.println(sql);
        
        session.createQuery(sql);
        
        return returnID;
    }
    
    public void deletePhysique(PersonnePhysique client){
        Session session= sessionFactory.getCurrentSession();
        String sql = "delete from PERSONNE_PHYSIQUE where idClient = " + client.getIdClient();
        session.createQuery(sql);
    }
    
    public void deleteMorale(PersonneMorale client){
        Session session= sessionFactory.getCurrentSession();
        String sql = "delete from PERSONNE_MORALE where idClient = " + client.getIdClient();
        session.createQuery(sql);
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
    
    public String insertCompte(Client client, CompteBancaire compte) {
    	
    	Session session = sessionFactory.getCurrentSession();
        
        int returnID =client.getIdClient();
        
        String sql = "insert into COMPTE_BANCAIRE(iban,proprietaire,swift_code,principal,idClient) " + 
        "SELECT iban,proprietaire,swift_code,principal,idClient from COMPTE_BANCAIRE";
        
        System.out.println(sql);
        
        session.createQuery(sql);
        
        return returnID + " : " + compte.getIBAN();
        
    }
    
}
