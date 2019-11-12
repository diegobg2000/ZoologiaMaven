package zoologiaMaven.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "informe")
public class InformeBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long codInforme;
	
	@Column
	private String fecha;
	
	@Column
	private String nombre;
	
	/********************************
	 * RELACIONES ENTRE TABLAS
	 ********************************/
	@ManyToMany
	private List<MovimientoBean> movimientos = new ArrayList<MovimientoBean>();
	
	@ManyToMany
	private List<BiologoBean> biologos = new ArrayList<BiologoBean>();
	
	
	/*********************************
	 * GETTERS AND SETTERS
	 *********************************/
	public long getCodInforme() {
		return codInforme;
	}

	public void setCodInforme(long codInforme) {
		this.codInforme = codInforme;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public List<BiologoBean> getBiologos() {
		return biologos;
	}

	public void setBiologos(List<BiologoBean> biologos) {
		this.biologos = biologos;
	}


}
