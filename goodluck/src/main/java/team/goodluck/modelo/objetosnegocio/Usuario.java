package team.goodluck.modelo.objetosnegocio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", catalog = "GOODLUCK-DATA", uniqueConstraints = @UniqueConstraint(columnNames = "usu_nombre"))
public class Usuario implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", unique = true, nullable = false, insertable = false, updatable = false)
	private Persona persona;
	@Column(name = "usu_nombre", unique = true, nullable = false, length = 45)
	private String nombre;
	@Column(name = "usu_clave", nullable = false, length = 45)
	private String clave;
	@Column(name = "usu_habilitado", nullable = false)
	private boolean habilitado;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Descarga> descargas = new ArrayList<Descarga>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Aporte> aportes = new ArrayList<Aporte>();

	public Usuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<Descarga> getDescargas() {
		return descargas;
	}

	public void setDescargas(List<Descarga> descargas) {
		this.descargas = descargas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Aporte> getAportes() {
		return aportes;
	}

	public void setAportes(List<Aporte> aportes) {
		this.aportes = aportes;
	}

}