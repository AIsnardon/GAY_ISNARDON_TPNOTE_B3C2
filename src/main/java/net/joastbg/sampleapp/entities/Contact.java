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
}
