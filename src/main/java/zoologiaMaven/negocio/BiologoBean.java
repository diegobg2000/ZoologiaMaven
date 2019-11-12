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
@Table(name="biologo")
public class BiologoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long codBiologo;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String provincia;
	
	@Column
	private String fechaTitulacion;
	
	/**********************************
	 * RELACIONES ENTRE TABLAS
	 ***********************************/
	@ManyToMany(mappedBy = "biologos")
	private List<InformeBean> informes = new ArrayList<InformeBean>();
	
	public void addInformeToBiologo(InformeBean informe) {
		if(!informes.contains(informe)) {
			informes.add(informe);
		}
		
		//
		List<BiologoBean> biologos = informe.getBiologos();
		if(!biologos.contains(this)) {
			biologos.add(this);
		}
	}
	/***************************************
	 * GETTES AND SETTERS
	 **************************************/

	public long getCodBiologo() {
		return codBiologo;
	}

	public void setCodBiologo(long codBiologo) {
		this.codBiologo = codBiologo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFechaTitulacion() {
		return fechaTitulacion;
	}

	public void setFechaTitulacion(String fechaTitulacion) {
		this.fechaTitulacion = fechaTitulacion;
	}

	public List<InformeBean> getInformes() {
		return informes;
	}

	public void setInformes(List<InformeBean> informes) {
		this.informes = informes;
	}
	
	
}
