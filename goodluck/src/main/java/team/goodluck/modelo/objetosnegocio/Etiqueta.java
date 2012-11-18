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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Etiqueta generated by hbm2java
 */
@Entity
@Table(name = "etiqueta", catalog = "goodluckdata")
public class Etiqueta implements java.io.Serializable {

	private static final long serialVersionUID = 8941536470995367144L;

	@Id
	@Column(name = "id_etiqueta", unique = true, nullable = false)
	private int id;
	@Column(name = "eti_nombre", length = 45)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "etiqueta")
	private List<Relacion> relaciones = new ArrayList<Relacion>();
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "relacion", catalog = "goodluckdata", joinColumns = { @JoinColumn(name = "eti_id_etiqueta", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "apo_id_aporte", nullable = false, updatable = false) })
	private List<Aporte> aportes = new ArrayList<Aporte>();

	public Etiqueta() {
	}

	public Etiqueta(int id) {
		this.id = id;
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