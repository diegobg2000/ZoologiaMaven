package zoologiaMaven.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "especies")
public class EspecieBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int codEspecie;
	@Column
	private String nombre;	
	@Column
	private String tipo;
	@Column
	private String periodosMigratorios;
	@Column
	private String caracteristicas;
	
	
	/*********************************
	  	RELACIONES ENTRE TABLAS
	 ********************************/
	/* Cuando la relacion es 1:1 es OneToMany --> Hay que crear un List
	 * en esta clase se pondria el cascade*/
	
	/*
	 * Es necesario que se cree la relacion de esta forma con la lista
	 * en la clase 1:1 ya que de esta forma la relacion 0:N que son muchos valores
	 * que corrsponden a una unica especie hace que el parametro que se le pasa
	 * al metodo add sea la clase Individuo que es la que hace referencia a muchos
	 * 
	 */
	
	@OneToMany(mappedBy = "especie")
	private List<IndividuoBean> individuos = new ArrayList<IndividuoBean>();
	
	public void addIndividuo(IndividuoBean individuo) {
		if(!individuos.contains(individuo)) {
			individuos.add(individuo);
			//Vinculamos este individuo con su especie
			individuo.setEspecie(this);
		}
	}

	/*
	 	SETTERS AND GETTERS
	 */
	public int getCodEspecie() {
		return codEspecie;
	}

	public void setCodEspecie(int codEspecie) {
		this.codEspecie = codEspecie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPeriodosMigratorios() {
		return periodosMigratorios;
	}

	public void setPeriodosMigratorios(String periodosMigratorios) {
		this.periodosMigratorios = periodosMigratorios;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<IndividuoBean> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(List<IndividuoBean> individuos) {
		this.individuos = individuos;
	}
	



	
}
