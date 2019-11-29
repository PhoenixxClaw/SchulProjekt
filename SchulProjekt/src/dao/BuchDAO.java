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
	
	public List<Buch> findAllBuecher() {
		TypedQuery<Buch> query = em.createNamedQuery("findAllBuecher", Buch.class);
		List<Buch> collection = query.getResultList();
		return collection;
	}
	
	public List<Buch> findByBuchTitel(String BuchTitel) {
		List<Buch> b = em.createQuery("SELECT b FROM Buch b WHERE b.Titel Like :vn").setParameter("vn", "%"+BuchTitel+"%").getResultList();
		//TypedQuery<Buch> p = (Buch) em.createQuery("select p from Buch p where p.BuchNummer like :vn").setParameter("vn", "%"+BuchTitel+"%");
		return b;
	}
	
	public List<Buch> findByISDN(String ISDN) {
		List<Buch> b = em.createQuery("SELECT b FROM Buch b WHERE b.ISDN Like :vn").setParameter("vn", "%"+ISDN+"%").getResultList();
		//TypedQuery<Buch> p = (Buch) em.createQuery("select p from Buch p where p.BuchNummer like :vn").setParameter("vn", "%"+BuchTitel+"%");
		return b;
	}
	
	public List<Buch> findByAuthor(String Author) {
		List<Buch> b = em.createQuery("SELECT b FROM Buch b WHERE b.Author Like :vn").setParameter("vn", "%"+Author+"%").getResultList();
		//TypedQuery<Buch> p = (Buch) em.createQuery("select p from Buch p where p.BuchNummer like :vn").setParameter("vn", "%"+BuchTitel+"%");
		return b;
	}
	
	public void persist(Buch Buch) {
		em.getTransaction().begin();
		em.persist(Buch);
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
	
	public void update(Buch buch) {
		em.getTransaction().begin();
		em.merge(buch);
		em.getTransaction().commit();
	}
}
