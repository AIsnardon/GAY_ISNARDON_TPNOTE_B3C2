package net.joastbg.sampleapp.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name= "ASSURANCE_AUTO")
public class AssuranceAuto extends Assurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5013193879099529620L;
	
	@Column(name = "immatriculation")
    private String immatriculation;
	
	@Column(name = "bonus_malus")
    private double bonus_malus;
	
	 @OneToOne
	   private Assurance assurance;

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public double getBonus_malus() {
		return bonus_malus;
	}

	public void setBonus_malus(double bonus_malus) {
		this.bonus_malus = bonus_malus;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	@Override
	public String toString() {
		return "AssuranceAuto [immatriculation=" + immatriculation + ", bonus_malus=" + bonus_malus + ", assurance="
				+ super.toString();
	}
	
	
}
