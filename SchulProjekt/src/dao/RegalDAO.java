package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Regal;

public class RegalDAO {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public RegalDAO() {
		factory = Persistence.createEntityManagerFactory("SchulProjekt");
		em = factory.createEntityManager();
	}
	
	public void shutdown() {
		em.close();
		factory.close();
		em = null;
		factory = null;
	}
	
	public Regal find(int id) {
		return em.find(Regal.class, id);
	}
	
	public List<Regal> findAllRegale() {
		TypedQuery<Regal> query = em.createNamedQuery("findAllRegal", Regal.class);
		List<Regal> collection = query.getResultList();
		return collection;
	}
	
	public Regal findByRegalName(String RegalName) {
		Regal p = (Regal) em.createQuery("select p from Regal p where p.RegalName = :vn")
				.setParameter("vn", RegalName)
				.getSingleResult();
		return p;
	}
	
	public void persist(Regal regal) {
		em.getTransaction().begin();
		em.persist(regal);
		em.getTransaction().commit();
	}
	
	public void delete(int id) {
		em.getTransaction().begin();
		Regal p = em.getReference(Regal.class, id); 
		em.remove(p);
		em.getTransaction().commit();
	}
	
/*	public void deleteAll() {
		em.getTransaction().begin();
		
		Query queryRegal = em.createQuery("DELETE FROM RegalName a");
		int anzahlRegal = queryRegal.executeUpdate();

		
		em.getTransaction().commit();
	}*/
	
	public void update(Regal regal) {
		em.getTransaction().begin();
		em.merge(regal);
		em.getTransaction().commit();
	}

}
