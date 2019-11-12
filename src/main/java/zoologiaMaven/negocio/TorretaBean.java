package zoologiaMaven.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="torreta")
public class TorretaBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long codTorreta;
	
	@Column
	private String nombre;
	
	@Column
	private String ubicacion;
	
	/******************************
	 * RELACIONES ENTRE TABLAS
	 ******************************/
	@OneToMany(mappedBy = "torreta")
	private List<MovimientoBean> movimientos = new ArrayList<MovimientoBean>();
	
	public void addMovimientoTorreta(MovimientoBean movimiento) {
		if(!movimientos.contains(movimiento)){
			movimientos.add(movimiento);
			movimiento.setTorreta(this);
		}
	}

	
	
	/*******************************************
	 * SETTERS AND GETTERS
	 ********************************************/
	public long getCodTorreta() {
		return codTorreta;
	}

	public void setCodTorreta(long codTorreta) {
		this.codTorreta = codTorreta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<MovimientoBean> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoBean> movimientos) {
		this.movimientos = movimientos;
	}
}
