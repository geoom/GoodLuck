package team.goodluck.modelo.objetosnegocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Etiqueta generated by hbm2java
 */
@Entity
@Table(name = "etiqueta", catalog = "goodluckdata")
@NamedQueries({ 
	@NamedQuery(name = "Etiqueta.encontrarEtiquetasBuscadas", query = "SELECT eti FROM Etiqueta eti WHERE eti IN (SELECT bc.etiqueta FROM BusquedaContexto bc WHERE bc IN :masBuscadas)"),
	@NamedQuery(name = "Etiqueta.encontrarEtiquetaPorNombre", query = "SELECT eti FROM Etiqueta eti WHERE eti.nombre=:nombre"),
	@NamedQuery(name = "Etiqueta.encontrarEtiquetasDescargadas", query = "SELECT eti FROM Etiqueta eti WHERE eti IN (SELECT rel.etiqueta FROM Relacion rel WHERE rel.aporte IN (SELECT des.aporte FROM Descarga des WHERE des.usuario=:usuario)) ")
	})
public class Etiqueta implements java.io.Serializable {

	private static final long serialVersionUID = 8941536470995367144L;

	@Id
	@Column(name = "id_etiqueta", unique = true, nullable = false)
	private int id;
	@Column(name = "eti_nombre", length = 45)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etiqueta")
	private List<Relacion> relaciones = new ArrayList<Relacion>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etiqueta")
	private List<BusquedaContexto> busquedasContexto = new ArrayList<BusquedaContexto>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "relacion", catalog = "goodluckdata", joinColumns = { @JoinColumn(name = "eti_id_etiqueta", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "apo_id_aporte", nullable = false, updatable = false) })
	private List<Aporte> aportes = new ArrayList<Aporte>();

	public Etiqueta() {
	}

	public Etiqueta(int id) {
		this.id = id;
	}
	
	public List<BusquedaContexto> getBusquedasContexto() {
		return busquedasContexto;
	}

	public void setBusquedasContexto(List<BusquedaContexto> busquedasContexto) {
		this.busquedasContexto = busquedasContexto;
	}

	public List<Relacion> getRelaciones() {
		return relaciones;
	}

	public void setRelaciones(List<Relacion> relaciones) {
		this.relaciones = relaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Aporte> getAportes() {
		return aportes;
	}

	public void setAportes(List<Aporte> aportes) {
		this.aportes = aportes;
	}

}