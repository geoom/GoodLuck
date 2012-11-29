package team.goodluck.modelo.objetosnegocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

@Entity
@Table(name = "aporte", catalog = "goodluckdata")
@NamedQueries({
		@NamedQuery(name = "Aporte.encontrarAportesMasVotados", query = "SELECT a FROM Aporte a ORDER BY a.votos"),
		@NamedQuery(name = "Aporte.encontrarAportesPorTituloEtiquetas", query = "SELECT DISTINCT(a) FROM Aporte a, Relacion rel WHERE a.titulo LIKE CONCAT('%',CONCAT(:titulo,'%')) AND rel.aporte=a AND rel IN (SELECT r FROM Relacion r WHERE r.etiqueta.nombre IN :etiquetas)"),
		@NamedQuery(name = "Aporte.encontrarAportesPorDescripcionEtiquetas", query = "SELECT DISTINCT(a) FROM Aporte a, Relacion rel WHERE a.descripcion LIKE CONCAT('%',CONCAT(:descripcion,'%')) AND rel.aporte=a AND rel IN (SELECT r FROM Relacion r WHERE r.etiqueta.nombre IN :etiquetas)"),
		@NamedQuery(name = "Aporte.encontrarAportesPorEtiquetas", query = "SELECT DISTINCT(a) FROM Aporte a, Relacion rel WHERE rel.aporte=a AND rel IN (SELECT r FROM Relacion r WHERE r.etiqueta.nombre IN :etiquetas)"),
		@NamedQuery(name = "Aporte.encontrarAportesMasBuscados", query = "SELECT DISTINCT(a) FROM Aporte a, Relacion rel WHERE rel.aporte=a AND rel IN (SELECT r FROM Relacion r WHERE r.etiqueta IN :etiquetas) ORDER BY a.fechaEntrada") })
public class Aporte implements java.io.Serializable {

	private static final long serialVersionUID = 2397977958555093698L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_aporte")
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usu_id_usuario")
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	@Column(name = "apo_fecha_entrada", nullable = false, length = 10)
	private Date fechaEntrada;
	@Column(name = "apo_titulo", nullable = false, length = 45)
	private String titulo;
	@Column(name = "apo_autor", nullable = false, length = 45)
	private String autor;
	@Column(name = "apo_descripcion", nullable = false, length = 500)
	private String descripcion;
	@Column(name = "apo_idioma", length = 45)
	private String idioma;
	@Temporal(TemporalType.DATE)
	@Column(name = "apo_fecha_publicacion", nullable = false, length = 10)
	private Date fechaPublicacion;
	@Column(name = "apo_paginas", nullable = false)
	private int paginas;
	@Column(name = "apo_habilitado", nullable = false)
	private boolean habilitado;
	@Column(name = "apo_votos", nullable = false)
	private int votos;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aporte")
	private List<Descarga> descargas = new ArrayList<Descarga>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aporte")
	private List<Relacion> relaciones = new ArrayList<Relacion>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aporte")
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "relacion", catalog = "goodluckdata", joinColumns = { @JoinColumn(name = "apo_id_aporte", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "eti_id_etiqueta", nullable = false, updatable = false) })
	private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();

	public Aporte() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
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

	public List<Relacion> getRelaciones() {
		return relaciones;
	}

	public void setRelaciones(List<Relacion> relaciones) {
		this.relaciones = relaciones;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

}