/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.dao;

import net.joastbg.sampleapp.entities.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Zzenl-Lsama
 */
public class ContactDao {
    @Autowired
    SessionFactory sessionFactory;

    public String persist(Contact contact){
        Session session = sessionFactory.getCurrentSession();
        String returnID = (String) session.save(contact);
        return returnID;
    }

    public Contact find(String idContact){
        Session session= sessionFactory.getCurrentSession();
        return (Contact) session.load(Contact.class, idContact);
    }

    public void delete(Contact contact){
        Session session= sessionFactory.getCurrentSession();
        session.delete(contact);
    }
}
