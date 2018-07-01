package net.joastbg.sampleapp.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name="Client")
public class Client  {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int idClient;

@OneToMany(mappedBy="CompteBancaire", cascade = {CascadeType.ALL})
private List<CompteBancaire> CompteBancaires = new ArrayList<CompteBancaire>();

@OneToMany(mappedBy="Contact", cascade = {CascadeType.ALL})
private List<Contact> Contacts = new ArrayList<Contact>();

@OneToMany(mappedBy="Assurance", cascade = {CascadeType.ALL})
private List<Assurance> Assurances = new ArrayList<Assurance>();

}



