package main.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compo")
public class Compo {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "ID_LIV")
	private int id_liv;

	@Column(name = "ID_EMP")
	private int id_emp;

	public int getId() {
		return id;
	}

	public int getId_liv() {
		return id_liv;
	}

	public int getId_emp() {
		return id_emp;
	}

}
