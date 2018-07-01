package net.joastbg.sampleapp.entities;

import javax.persistence.*;



@Entity
@Table(name="Compte_Bancaire")
public class CompteBancaire {
@Id
private String IBAN;

@Column
private String BIC;

@Column
private Boolean principal;

@ManyToOne
@JoinColumn(name="idClient")
public Client client;

}
