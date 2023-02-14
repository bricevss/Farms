package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Farm;

public class FarmServices {
	public Farm getById(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	

			return em.find(Farm.class, id);
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public List<Farm> getAll(){
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			return em.createQuery("From Farm", Farm.class).getResultList();
		}finally {
			
		}
	}
	
	public void create(Farm f) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();

			em.persist(f);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public static void update(Farm f) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Farm farm = em.find(Farm.class, f.getId());
			
			farm.setNom(f.getNom());
			farm.setLocalisation(f.getLocalisation());
			farm.setSuperficie(f.getSuperficie());
			
			em.persist(farm);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public void delete(Farm f) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Farm farm = em.find(Farm.class, f.getId());
			em.remove(farm);
			trans.commit();
			
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}

}
