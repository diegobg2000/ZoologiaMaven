package zoologiaMaven.modelo.especie;

import javax.persistence.EntityManager;

import zoologiaMaven.negocio.EspecieBean;
import zoologiaMaven.util.ConnectionEntityManagerFactory;

public class CreateEspecie {
	public void create(EspecieBean especie){
	EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(especie);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
