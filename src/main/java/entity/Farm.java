package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name ="farm")@Table(name ="farm")
public class Farm {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String localisation;
	private int superficie;
	
	@OneToMany
	@JoinTable( name = "farm_machine",
				joinColumns =  @JoinColumn(name ="farm_id"),
				inverseJoinColumns = @JoinColumn(name = "machine_id"))
	
	List<Machine> machines;
	
	List<Machine> getMachine(){
		return machines;
	}
	
	@OneToMany( targetEntity = Animaux.class, mappedBy = "farm" )
	List<Animaux> animaux;

	public void setAnimaux(List<Animaux> animaux) {
		this.animaux = animaux;
	}
	public List<Animaux> getAnimaux() {
		return animaux;
	}
	
	public Farm() {
		super();
	}

	public Farm(int id, String nom, String localisation, int superficie) {
		super();
		this.id = id;
		this.nom = nom;
		this.localisation = localisation;
		this.superficie = superficie;
	}
	
	public Farm(String nom, String localisation, int superficie) {
		super();
		this.nom = nom;
		this.localisation = localisation;
		this.superficie = superficie;
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


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	@Override
	public String toString() {
		return "Farm [id=" + id + ", nom=" + nom + ", localisation=" + localisation + ", superficie=" + superficie
				+ "]";
	}

	

}
