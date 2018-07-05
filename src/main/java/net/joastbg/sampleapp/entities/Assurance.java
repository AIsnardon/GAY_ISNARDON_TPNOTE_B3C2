package net.joastbg.sampleapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "ASSURANCE")
public abstract class Assurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 574779180656266341L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAssurance;
	
	@Column(name = "dateSouscription")
    private Date dateSouscription;
	
	@Column(name = "dateAnniversaire")
    private Date dateAnniversaire;
	
	@Column(name = "datePrelevement")
    private Date datePrelevement;
	
	@ManyToOne
	   @JoinColumn(name = "idClient")
	   private Client client;

	 @OneToOne(mappedBy = "assurance")
	   private AssuranceAuto assuranceAuto;
	 
	 @OneToOne(mappedBy = "assurance")
	   private AssuranceHabitat assuranceHabitat;
	 
	 @OneToOne(mappedBy = "assurance")
	   private Echeances echeances;
	 
	 
	@Override
	public String toString() {
		return "Assurance [idAssurance=" + idAssurance + ", dateSouscription=" + dateSouscription
				+ ", dateAnniversaire=" + dateAnniversaire + ", datePrelevement=" + datePrelevement + ", client="
				+ client + ", echeances=" + echeances + "]";
	}

	public Echeances getEcheances() {
		return echeances;
	}

	public void setEcheances(Echeances echeances) {
		this.echeances = echeances;
	}

	public Long getIdAssurance() {
		return idAssurance;
	}

	public void setIdAssurance(Long idAssurance) {
		this.idAssurance = idAssurance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AssuranceAuto getAssuranceAuto() {
		return assuranceAuto;
	}

	public void setAssuranceAuto(AssuranceAuto assuranceAuto) {
		this.assuranceAuto = assuranceAuto;
	}

	public AssuranceHabitat getAssuranceHabitat() {
		return assuranceHabitat;
	}

	public void setAssuranceHabitat(AssuranceHabitat assuranceHabitat) {
		this.assuranceHabitat = assuranceHabitat;
	}


	public Date getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public Date getDateAnniversaire() {
		return dateAnniversaire;
	}

	public void setDateAnniversaire(Date dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public Date getDatePrelevement() {
		return datePrelevement;
	}

	public void setDatePrelevement(Date datePrelevement) {
		this.datePrelevement = datePrelevement;
	}

	
}
