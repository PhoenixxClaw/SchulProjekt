package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Ausweis;

public class AusweisDAO {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public AusweisDAO() {
		factory = Persistence.createEntityManagerFactory("SchulProjekt");
		em = factory.createEntityManager();
	}
	
	public void shutdown() {
		em.close();
		factory.close();
		em = null;
		factory = null;
	}
	
	public Ausweis find(int id) {
		return em.find(Ausweis.class, id);
	}
	
	public List<Ausweis> findAllAusweise() {
		TypedQuery<Ausweis> query = em.createNamedQuery("findAllAusweise", Ausweis.class);
		List<Ausweis> collection = query.getResultList();
		return collection;
	}
	
	public Ausweis findByAusweisNummer(int AusweisNummer) {
		Ausweis p = (Ausweis) em.createQuery("select p from Ausweis p where p.AusweisNummer = :vn")
				.setParameter("vn", AusweisNummer)
				.getSingleResult();
		return p;
	}
	
	public void persist(Ausweis ausweis) {
		em.getTransaction().begin();
		em.persist(ausweis);
		em.getTransaction().commit();
	}
	
	public void delete(int id) {
		em.getTransaction().begin();
		Ausweis p = em.getReference(Ausweis.class, id); 
		em.remove(p);
		em.getTransaction().commit();
	}
	
/*	public void deleteAll() {
		em.getTransaction().begin();
		
		Query queryAusweis = em.createQuery("DELETE FROM AusweisName a");
		int anzahlAusweis = queryAusweis.executeUpdate();

		
		em.getTransaction().commit();
	}*/
	
	public void update(Ausweis ausweis) {
		em.getTransaction().begin();
		em.merge(ausweis);
		em.getTransaction().commit();
	}
}
