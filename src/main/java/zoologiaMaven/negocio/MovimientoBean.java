package zoologiaMaven.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class MovimientoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long cod_movimiento;
	
	@Column
	private String fecha;
	
	@Column
	private String tipo;
	
	@Column
	private String hora;
	
	
	
	
	/******************************************
	 * RELACIONES ENTRE TABLAS
	 ******************************************/
	@ManyToOne
	private IndividuoBean individuo;

	@ManyToOne
	private TorretaBean torreta;
	
	@ManyToMany(mappedBy = "movimientos")
	private List<InformeBean> informes = new ArrayList<InformeBean>();
	
		public void addInforme(InformeBean informe) {
			if(!informes.contains(informe)) {
				informes.add(informe);
			}
				//
				List<MovimientoBean> movimientos = informe.getMovimientos();
				if(!movimientos.contains(this)) {
					movimientos.add(this);
				
				
			}
			
		}
	

	
	/********************************************
	 * SETTERS AND GETTERS
	 ********************************************/
	
		public long getCod_movimiento() {
		return cod_movimiento;
	}




	public List<InformeBean> getInformes() {
		return informes;
	}



	public void setInformes(List<InformeBean> informes) {
		this.informes = informes;
	}



	public void setCod_movimiento(long cod_movimiento) {
		this.cod_movimiento = cod_movimiento;
	}




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public IndividuoBean getIndividuo() {
		return individuo;
	}




	public void setIndividuo(IndividuoBean individuo) {
		this.individuo = individuo;
	}




	public TorretaBean getTorreta() {
		return torreta;
	}




	public void setTorreta(TorretaBean torreta) {
		this.torreta = torreta;
	}
	
	


}



