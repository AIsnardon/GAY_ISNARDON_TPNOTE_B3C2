package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name="PersonneMorale")
public class PersonneMorale extends Client {
    
@Column
private String Siren;

@Column
private String Nom;
    
}
