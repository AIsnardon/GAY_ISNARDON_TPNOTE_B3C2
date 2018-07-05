package net.joastbg.sampleapp.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="PERSONNE_PHYSIQUE")
public class PersonnePhysique extends Client {
    
@Column(name="nom")
private String Nom;

@Column(name="prenom")
private String Prenom;

@Column(name="dateNaissance")
private Date DateNaissance;

public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}

public String getPrenom() {
	return Prenom;
}

public void setPrenom(String prenom) {
	Prenom = prenom;
}

public Date getDateNaissance() {
	return DateNaissance;
}

public void setDateNaissance(Date dateNaissance) {
	DateNaissance = dateNaissance;
}

@Override
public String toString() {
	
	return "PersonnePhysique [Nom=" + Nom + ", Prenom=" + Prenom + ", DateNaissance=" + DateNaissance + "]";
}
    


}
