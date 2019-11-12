package zoologiaMaven.modelo.torreta;

import javax.persistence.EntityManager;

import zoologiaMaven.negocio.TorretaBean;
import zoologiaMaven.util.ConnectionEntityManagerFactory;

public class CreateTorreta {
	public void create(TorretaBean torreta) {
		EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(torreta);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
