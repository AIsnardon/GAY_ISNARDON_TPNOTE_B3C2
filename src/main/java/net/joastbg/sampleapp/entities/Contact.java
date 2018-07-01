package net.joastbg.sampleapp.entities;
import javax.persistence.*;

@Entity
@Table(name="Contact")
public class Contact {
    @Id
private String Id;

@Column
private String Type;

@Column
private String Valeur;

@ManyToOne
@JoinColumn(name="idClient")
public Client client;

@Override
public String toString() {
	return "Contact [Id=" + Id + ", Type=" + Type + ", Valeur=" + Valeur + ", client=" + client + "]";
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public String getValeur() {
	return Valeur;
}

public void setValeur(String valeur) {
	Valeur = valeur;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}



}
