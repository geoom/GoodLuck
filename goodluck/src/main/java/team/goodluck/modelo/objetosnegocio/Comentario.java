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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comentario", catalog = "goodluckdata")
public class Comentario implements java.io.Serializable {

	private static final long serialVersionUID = -8657526105088746178L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_comentario", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apo_id_aporte", nullable = false)
	private Aporte aporte;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usu_id_usuario")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "com_id_comentario")
	private Comentario comentario;
	@Temporal(TemporalType.DATE)
	@Column(name = "com_fecha", nullable = false, length = 10)
	private Date fecha;
	@Column(name = "com_contenido", nullable = false, length = 500)
	private String contenido;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comentario")
	private List<Comentario> comentariosHijos = new ArrayList<Comentario>();

	public Comentario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aporte getAporte() {
		return aporte;
	}

	public void setAporte(Aporte aporte) {
		this.aporte = aporte;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public List<Comentario> getComentariosHijos() {
		return comentariosHijos;
	}

	public void setComentariosHijos(List<Comentario> comentariosHijos) {
		this.comentariosHijos = comentariosHijos;
	}

}