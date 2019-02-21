package main.banque.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String numero;

	@Column
	private double solde;

	// relation compte client
	@ManyToMany(mappedBy = "compte")
	private List<Client> clientCompte = new ArrayList<>();

	// relation compte - operation
	@OneToMany(mappedBy = "compteOp")
	private List<Operation> operation = new ArrayList<>();

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Client> getClientCompte() {
		return clientCompte;
	}

	public void setClientCompte(List<Client> clientCompte) {
		this.clientCompte = clientCompte;
	}

	public int getId() {
		return id;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

}
