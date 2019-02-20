package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "livre")
public class Livre {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "AUTEUR")
	private String auteur;

	@Column(name = "TITRE")
	private String titre;
	
	@ManyToMany
    @JoinTable(name="COMPO", 
               joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
	           inverseJoinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID")
    )
	private List<Emprunt> emprunt = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}
	
	

}
