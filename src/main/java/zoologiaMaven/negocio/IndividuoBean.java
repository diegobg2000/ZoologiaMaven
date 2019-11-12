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
@Table(name="individuos")
	public class IndividuoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int codigo;
	
	@Column
	private String nombre;
	
	@Column
	private int peso;
	
	@Column
	private String dimensiones;
	
	
	/*
	 * RELACINES ENTRE TABLAS
	 */
	@ManyToOne
	private EspecieBean especie;

	@OneToMany(mappedBy = "individuo" )
	private List<MovimientoBean> movimientos = new ArrayList<MovimientoBean>();
	
		public void addMovimiento(MovimientoBean movimiento){
			if(!movimientos.contains(movimiento)){
				movimientos.add(movimiento);
				movimiento.setIndividuo(this);
			}
		}

		/*
		 	SETTERS AND GETTES
		 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public EspecieBean getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieBean especie) {
		this.especie = especie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MovimientoBean> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoBean> movimientos) {
		this.movimientos = movimientos;
	}

}
