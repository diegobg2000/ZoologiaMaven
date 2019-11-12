package zoologiaMaven.modelo.movimiento;

import javax.persistence.EntityManager;

import zoologiaMaven.negocio.MovimientoBean;
import zoologiaMaven.util.ConnectionEntityManagerFactory;

public class CreateMovimiento {
	public void create(MovimientoBean movimiento) {
		
	EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(movimiento);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
