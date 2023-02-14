package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Animaux;

public class AnimauxServices {
	
	public static Animaux getById(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	

			return em.find(Animaux.class, id);
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public static List<Animaux> getAll(){
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			return em.createQuery("From animaux", Animaux.class).getResultList();
		}finally {
			
		}
	}
	
	public void create(Animaux a) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();

			em.persist(a);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public static void update(Animaux a) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Animaux animaux = em.find(Animaux.class, a.getId());
			
			animaux.setNombre(a.getNombre());
			animaux.setNom(a.getNom());
			animaux.setPrix(a.getPrix());
			
			em.persist(animaux);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public void delete(Animaux m) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Animaux machine = em.find(Animaux.class, m.getId());
			em.remove(machine);
			trans.commit();
			
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
}