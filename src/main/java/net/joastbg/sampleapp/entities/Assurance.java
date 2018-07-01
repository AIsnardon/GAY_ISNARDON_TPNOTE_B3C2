package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
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
    private String dateSouscription;
	
	@Column(name = "dateAnniversaire")
    private String dateAnniversaire;
	
	@Column(name = "datePrelevement")
    private String datePrelevement;
	
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
				+ client + ", assuranceAuto=" + assuranceAuto + ", assuranceHabitat=" + assuranceHabitat
				+ ", echeances=" + echeances + "]";
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


	public String getDateSouscription() {
		return dateSouscription;
	}

	public void setDateSouscription(String dateSouscription) {
		this.dateSouscription = dateSouscription;
	}

	public String getDateAnniversaire() {
		return dateAnniversaire;
	}

	public void setDateAnniversaire(String dateAnniversaire) {
		this.dateAnniversaire = dateAnniversaire;
	}

	public String getDatePrelevement() {
		return datePrelevement;
	}

	public void setDatePrelevement(String datePrelevement) {
		this.datePrelevement = datePrelevement;
	}

	
}
