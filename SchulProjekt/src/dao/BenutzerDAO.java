package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Benutzer;

public class BenutzerDAO {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public BenutzerDAO() {
		factory = Persistence.createEntityManagerFactory("SchulProjekt");
		em = factory.createEntityManager();
	}
	
	public void shutdown() {
		em.close();
		factory.close();
		em = null;
		factory = null;
	}
	
	public Benutzer find(int id) {
		return em.find(Benutzer.class, id);
	}
	
	public List<Benutzer> findAllBenutzer() {
		TypedQuery<Benutzer> query = em.createNamedQuery("findAllBenutzer", Benutzer.class);
		List<Benutzer> collection = query.getResultList();
		return collection;
	}
	
	public Benutzer findByBenutzerName(String BenutzerName) {
		Benutzer p = (Benutzer) em.createQuery("select p from Benutzer p where p.benutzerName = :vn")
				.setParameter("vn", BenutzerName)
				.getSingleResult();
		return p;
	}
	
	public Benutzer findByBenutzerNummer(String BenutzerNummer) {
		Benutzer p = (Benutzer) em.createQuery("select p from Benutzer p where p.benutzerNummer = :vn")
				.setParameter("vn", BenutzerNummer)
				.getSingleResult();
		return p;
	}
	
	public void persist(Benutzer art) {
		em.getTransaction().begin();
		em.persist(art);
		em.getTransaction().commit();
	}
	
	public void delete(int id) {
		em.getTransaction().begin();
		Benutzer p = em.getReference(Benutzer.class, id); 
		em.remove(p);
		em.getTransaction().commit();
	}
	
/*	public void deleteAll() {
		em.getTransaction().begin();
		
		Query queryBenutzer = em.createQuery("DELETE FROM BenutzerName a");
		int anzahlBenutzer = queryBenutzer.executeUpdate();

		
		em.getTransaction().commit();
	}*/
	
	public void update(Benutzer benutzer) {
		em.getTransaction().begin();
		em.merge(benutzer);
		em.getTransaction().commit();
	}

}
