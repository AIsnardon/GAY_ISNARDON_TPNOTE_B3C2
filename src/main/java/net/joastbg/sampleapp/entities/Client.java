package net.joastbg.sampleapp.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Client")
public class Client  {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int idClient;

@OneToMany(mappedBy="client", cascade = {CascadeType.ALL})
private List<CompteBancaire> CompteBancaires = new ArrayList<CompteBancaire>();

@OneToMany(mappedBy="client", cascade = {CascadeType.ALL})
private List<Contact> Contacts = new ArrayList<Contact>();

@OneToMany(mappedBy="client", cascade = {CascadeType.ALL})
private List<Assurance> Assurances = new ArrayList<Assurance>();

@OneToMany(mappedBy="client", cascade = {CascadeType.ALL})
private List<Sinistre> Sinistres = new ArrayList<Sinistre>();

public int getIdClient() {
	return idClient;
}

public void setIdClient(int idClient) {
	this.idClient = idClient;
}

public List<CompteBancaire> getCompteBancaires() {
	return CompteBancaires;
}

public void setCompteBancaires(List<CompteBancaire> compteBancaires) {
	CompteBancaires = compteBancaires;
}

public List<Contact> getContacts() {
	return Contacts;
}

public void setContacts(List<Contact> contacts) {
	Contacts = contacts;
}

public List<Assurance> getAssurances() {
	return Assurances;
}

public void setAssurances(List<Assurance> assurances) {
	Assurances = assurances;
}

@Override
public String toString() {
	return "Client [idClient=" + idClient + ", CompteBancaires=" + CompteBancaires + ", Contacts=" + Contacts
			+ ", Assurances=" + Assurances + "]";
}

}



