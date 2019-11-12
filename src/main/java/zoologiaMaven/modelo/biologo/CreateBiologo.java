package zoologiaMaven.modelo.biologo;

import javax.persistence.EntityManager;

import zoologiaMaven.negocio.BiologoBean;
import zoologiaMaven.util.ConnectionEntityManagerFactory;

public class CreateBiologo {
	public void create(BiologoBean biologo) {
		EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(biologo);
		entityManager.getTransaction().commit();
		entityManager.close();
	
	}
}
