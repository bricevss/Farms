package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="machine") @Table(name="machine")
public class Machine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private int prix;
	private String date_achat;
	
	@ManyToOne
	@JoinTable( name = "farm_machine",
				joinColumns =  @JoinColumn(name ="machine_id"),
				inverseJoinColumns = @JoinColumn(name = "farm_id"))
	
	private Farm farm;
	
	public Machine(int id, String nom, int prix, String date_achat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.date_achat = date_achat;
	}

	public Machine(String nom, int prix, String date_achat) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.date_achat = date_achat;
	}

	public Machine() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDate_achat() {
		return date_achat;
	}

	public void setDate_achat(String date_achat) {
		this.date_achat = date_achat;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", nom=" + nom + ", prix=" + prix + ", date_achat=" + date_achat + ", farm=" + farm
				+ "]";
	}

}
