package net.joastbg.sampleapp.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="PersonnePhysique")
public class PersonnePhysique extends Client {
    
@Column
private String Nom;

@Column
private String Prenom;

@Column
private Date DateNaissance;
    
}
