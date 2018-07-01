package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ECHEANCES")
public class Echeances implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1088262973262594032L;
	
	@Id
	private Long idAssurance;
	
	@Column(name = "prix")
    private String prix;
	
	@Column(name = "dateEmission")
    private String dateEmission;
	
	@Column(name = "datePaiement")
    private String datePaiement;
	
	@Column(name = "dateEmissionFacture")
    private String dateEmissionFacture;
	
	@OneToOne
	   private Assurance assurance;

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(String dateEmission) {
		this.dateEmission = dateEmission;
	}

	public String getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}

	public String getDateEmissionFacture() {
		return dateEmissionFacture;
	}

	public void setDateEmissionFacture(String dateEmissionFacture) {
		this.dateEmissionFacture = dateEmissionFacture;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	@Override
	public String toString() {
		return "Echeances [prix=" + prix + ", dateEmission=" + dateEmission + ", datePaiement=" + datePaiement
				+ ", dateEmissionFacture=" + dateEmissionFacture + ", assurance=" + assurance + "]";
	}
	
	
}
