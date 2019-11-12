package zoologiaMaven.modelo.individuo;
import javax.persistence.EntityManager;

import zoologiaMaven.negocio.IndividuoBean;
import zoologiaMaven.util.ConnectionEntityManagerFactory;


public class CreateIndividuo {
	public void create(IndividuoBean individuo) {
		//Recoje la conexion
		EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		// empieza la transaccion, persistimos y cerramos
		entityManager.getTransaction()/*Retorna un recurso de Entity Manager Object. Es un commit*/.begin();//Preparacion de los objetos de la clase Start 
		entityManager.persist(individuo);//Fabrica la instacia y al persistencia. Introduce lo que fue a buscar a la clase start antes
		entityManager.getTransaction().commit();/*Comprueban si esta bien los datos por ejemplo que no se dupliquen la primary key. Si todo esta bien retorna true*/
		entityManager.close();
	}
}
