package main.banque.entite;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	

}
