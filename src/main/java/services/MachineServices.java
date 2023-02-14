package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Machine;

public class MachineServices {
	
	public Machine getById(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	

			return em.find(Machine.class, id);
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public List<Machine> getAll(){
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			return em.createQuery("From Machine", Machine.class).getResultList();
		}finally {
			
		}
	}
	
	public void create(Machine m) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();

			em.persist(m);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public static void update(Machine m) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Machine machine = em.find(Machine.class, m.getId());
			
			machine.setNom(m.getNom());
			machine.setPrix(m.getPrix());
			machine.setDate_achat(m.getDate_achat());
			
			em.persist(machine);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
	public void delete(Machine m) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Machine machine = em.find(Machine.class, m.getId());
			em.remove(machine);
			trans.commit();
			
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}

	
	public static void main(String[] args) {
		MachineServices service = new MachineServices();
		
		//Get by id
		Machine getMachine = service.getById(1);
		System.out.println(getMachine);
	
	}

}