/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Sinistre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Zzenl-Lsama
 */
public class SinistreDao {
    
     @Autowired
    SessionFactory sessionFactory;

    public String persist(Sinistre sinistre){
        Session session = sessionFactory.getCurrentSession();
        String returnID = (String) session.save(sinistre);
        return returnID;
    }

    public Sinistre find(String idsinistre){
        Session session= sessionFactory.getCurrentSession();
        return (Sinistre) session.load(Sinistre.class, idsinistre);
    }

    public void delete(Sinistre sinistre){
        Session session= sessionFactory.getCurrentSession();
        session.delete(sinistre);
    }
    
}
