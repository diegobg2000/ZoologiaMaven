package zoologiaMaven.inicio;

import zoologiaMaven.modelo.biologo.CreateBiologo;
import zoologiaMaven.modelo.especie.CreateEspecie;
import zoologiaMaven.modelo.individuo.CreateIndividuo;
import zoologiaMaven.modelo.informe.CreateInforme;
import zoologiaMaven.modelo.movimiento.CreateMovimiento;
import zoologiaMaven.modelo.torreta.CreateTorreta;
import zoologiaMaven.negocio.BiologoBean;
import zoologiaMaven.negocio.EspecieBean;
import zoologiaMaven.negocio.IndividuoBean;
import zoologiaMaven.negocio.InformeBean;
import zoologiaMaven.negocio.MovimientoBean;
import zoologiaMaven.negocio.TorretaBean;

public class Start {

	public static void main(String[] args) {
		/*
		 * CREAMOS LOS OBJETOS
		 */
		//Especies 
		EspecieBean leon = new EspecieBean();
		leon.setNombre("Leon");
		leon.setTipo("Mamifero");//Mamifero, Ovoviviparo o Oviparo  
		leon.setPeriodosMigratorios("");
		leon.setCaracteristicas("Es un depredador, dientes afilados, gran embergadora, carnivoro");
		
		EspecieBean aguila = new EspecieBean();
		aguila.setNombre("Aguila");
		aguila.setTipo("Oviparo");
		aguila.setPeriodosMigratorios("Verano");
		aguila.setCaracteristicas("Un podoeroso depredador que ataca a sus presas desde el aire y los atrapa con sus fuertes garras");
	
		
		//Individuos
		IndividuoBean leon1 = new IndividuoBean();
		leon1.setNombre("Leon 1");
		leon1.setPeso(80);
		leon1.setDimensiones("178");
		
		IndividuoBean leon2 = new IndividuoBean();
		leon2.setNombre("Leon 2");
		leon2.setPeso(60);
		leon2.setDimensiones("170");
		
		IndividuoBean aguila1 = new IndividuoBean();
		aguila1.setNombre("Aguila 1");
		aguila1.setPeso(60);
		aguila1.setDimensiones("170");
		
		//Movimientos
		MovimientoBean movimiento1 = new MovimientoBean();
		movimiento1.setFecha("22-10-2019");
		movimiento1.setHora("12.45");
		movimiento1.setTipo("Tipo 1");
		
		//Torretas
		TorretaBean torreta1 = new TorretaBean();
		torreta1.setNombre("Torreta 1");
		torreta1.setUbicacion("Pumarin");
		
		//Informes
		InformeBean informe1 = new InformeBean();
		informe1.setFecha("12-2-2019");
		informe1.setNombre("Informe 1");
		
		//Biologos
		BiologoBean biologo1 = new BiologoBean();
		biologo1.setNombre("Biologo1");
		biologo1.setDireccion("Evaristo Valle 15");
		biologo1.setProvincia("Asturias");
		biologo1.setFechaTitulacion("11-7-2005");
		
		
		
		/**************************************************
		 * PERSISTIMOS
		 * Es muy importante el oden de la persistencia en el caso de no utilizar cascades hay que
		 * seguir un riguroso orden.
		 * Este orden consiste en persistir primero los objetos de los extremsos(los que solo tienen una union) y que solo tengan 1:1
		 * despues de estos va el que esta conectado que tenga mas 1:1
		 * y por ultimo los N:N y mas si estan en los extremoss
		 * 
		 * ****************************************************
		 * Segunda observacion:
		 * Primero se crean las tablas de los extremos que sean 1:1
		 ***************************************************/
		//CreateTorreta
		CreateTorreta createTorreta = new CreateTorreta();
		createTorreta.create(torreta1);
		System.out.println("SE HA CREADO LA TORRETA");
		//addMovimientoTorreta
		torreta1.addMovimientoTorreta(movimiento1);
		System.out.println("SE HA AÑADIDO EL MOVIMINETO A LA TORRETA 1");
				
		//CreateEspecie
		CreateEspecie createEspecie = new CreateEspecie();
		createEspecie.create(leon);
		createEspecie.create(aguila);
		//addIndividuo
		leon.addIndividuo(leon1);
		leon.addIndividuo(leon2);
		
		aguila.addIndividuo(aguila1);
		
			
		//CreateIndividuo
		CreateIndividuo createIndividuo = new CreateIndividuo();
		createIndividuo.create(leon1);
		createIndividuo.create(leon2);
		
		createIndividuo.create(aguila1);
		
		//addMovimiento
		aguila1.addMovimiento(movimiento1);
		
		
		//CreateMovimiento
		CreateMovimiento createMovimiento = new CreateMovimiento();
		createMovimiento.create(movimiento1);
		//addInforme
		movimiento1.addInforme(informe1);
		
		//CreateBiologo
		CreateBiologo createBiologo = new CreateBiologo();
		createBiologo.create(biologo1);
		
		biologo1.addInformeToBiologo(informe1);
		
		//CreateInforme
		CreateInforme createInforme = new CreateInforme();
		createInforme.create(informe1);
		
	
		
		
	
		
				

	}

}
