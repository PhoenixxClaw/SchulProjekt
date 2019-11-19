package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Buch;

public class BuchDAO {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public BuchDAO() {
		factory = Persistence.createEntityManagerFactory("SchulProjekt");
		em = factory.createEntityManager();
	}
	
	public void shutdown() {
		em.close();
		factory.close();
		em = null;
		factory = null;
	}
	
	public Buch find(int id) {
		return em.find(Buch.class, id);
	}
	
	public List<Buch> findAllBuche() {
		TypedQuery<Buch> query = em.createNamedQuery("findAllBuch", Buch.class);
		List<Buch> collection = query.getResultList();
		return collection;
	}
	
	public Buch findByBuchNummer(String BuchNummer) {
		Buch p = (Buch) em.createQuery("select p from Buch p where p.BuchNummer = :vn")
				.setParameter("vn", BuchNummer)
				.getSingleResult();
		return p;
	}
	
	public void persist(Buch ausweis) {
		em.getTransaction().begin();
		em.persist(ausweis);
		em.getTransaction().commit();
	}
	
	public void delete(int id) {
		em.getTransaction().begin();
		Buch p = em.getReference(Buch.class, id); 
		em.remove(p);
		em.getTransaction().commit();
	}
	
/*	public void deleteAll() {
		em.getTransaction().begin();
		
		Query queryBuch = em.createQuery("DELETE FROM BuchName a");
		int anzahlBuch = queryBuch.executeUpdate();

		
		em.getTransaction().commit();
	}*/
	
	public void update(Buch ausweis) {
		em.getTransaction().begin();
		em.merge(ausweis);
		em.getTransaction().commit();
	}
}
