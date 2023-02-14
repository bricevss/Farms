package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="animaux") @Table(name="animaux")
public class Animaux {
	
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private int nombre;
	private String nom;
	private int prix;
	private int farm_id;
	
	@OneToOne
	@JoinColumn(name="farm_id", nullable = false, insertable=false, updatable=false)
	private Farm farm;


	public Animaux() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getFarm_id() {
		return farm_id;
	}

	public void setFarm_id(int farm_id) {
		this.farm_id = farm_id;
	}


	@Override
	public String toString() {
		return "Animaux [id=" + id + ", nombre=" + nombre + ", nom=" + nom + ", prix=" + prix + "]";
	}
	
	

}
