package zoologiaMaven.modelo.informe;

import javax.persistence.EntityManager;

import zoologiaMaven.negocio.InformeBean;
import zoologiaMaven.util.ConnectionEntityManagerFactory;

public class CreateInforme {
	public void create(InformeBean informe) {
		EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(informe);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
