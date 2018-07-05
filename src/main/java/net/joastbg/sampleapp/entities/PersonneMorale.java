package net.joastbg.sampleapp.entities;

import javax.persistence.*;

@Entity
@Table(name="PERSONNE_MORALE")
public class PersonneMorale extends Client {
    
@Column
private String Siren;

@Column
private String Nom;

public String getSiren() {
	return Siren;
}

public void setSiren(String siren) {
	Siren = siren;
}

public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}

@Override
public String toString() {
	return "PersonneMorale [Siren=" + Siren + ", Nom=" + Nom + "]";
}
    


}
