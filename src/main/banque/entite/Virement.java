package main.banque.entite;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String beneficiaire;

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
