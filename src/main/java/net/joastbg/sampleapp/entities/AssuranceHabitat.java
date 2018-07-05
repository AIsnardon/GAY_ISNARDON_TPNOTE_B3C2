package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name= "ASSURANCE_HABITATION")
public class AssuranceHabitat extends Assurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5645381708288410304L;
	
	@Column(name = "adresse")
    private String adresse;
	
	@Column(name = "valeurConverture")
    private int valeurConverture;
	
	 @OneToOne
	   private Assurance assurance;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getValeurConverture() {
		return valeurConverture;
	}

	public void setValeurConverture(int valeurConverture) {
		this.valeurConverture = valeurConverture;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	@Override
	public String toString() {
		return "AssuranceHabitat [adresse=" + adresse + ", valeurConverture=" + valeurConverture + ", assurance="
				+ super.toString();
	}
	
	 
}
