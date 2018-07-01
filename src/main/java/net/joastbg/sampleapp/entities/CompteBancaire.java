package net.joastbg.sampleapp.entities;

import javax.persistence.*;



@Entity
@Table(name="Compte_Bancaire")
public class CompteBancaire {
	
@Id

private String IBAN;

@Column(name = "proprietaire")
private String proprietaire;

@Column(name = "swift_code")
private String swift_code;

@ManyToOne
@JoinColumn(name="idClient")
public Client client;

public String getIBAN() {
	return IBAN;
}

public void setIBAN(String iBAN) {
	IBAN = iBAN;
}

public String getProprietaire() {
	return proprietaire;
}

public void setProprietaire(String proprietaire) {
	this.proprietaire = proprietaire;
}

public String getSwift_code() {
	return swift_code;
}

public void setSwift_code(String swift_code) {
	this.swift_code = swift_code;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

@Override
public String toString() {
	return "CompteBancaire [IBAN=" + IBAN + ", proprietaire=" + proprietaire + ", swift_code=" + swift_code
			+ ", client=" + client + "]";
}



}
