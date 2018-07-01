/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.joastbg.sampleapp.entities;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author aymri
 */
@Entity
@Table(name="sinistre")
public class Sinistre {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long idSinistre;
	
@ManyToOne
@JoinColumn(name="idClient")
public Client client;

@ManyToOne
@JoinColumn(name="Assurance")
public Assurance assurance;

@Column
private Date date;

@Column
private String titre;

@Column
private String description;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
