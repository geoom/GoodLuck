package team.goodluck.modelo.objetosnegocio;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "descarga", catalog = "goodluckdata")
public class Descarga implements java.io.Serializable {

	private static final long serialVersionUID = -8011621707895470786L;
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idUsuario", column = @Column(name = "usu_id_usuario", nullable = false)),
			@AttributeOverride(name = "idAporte", column = @Column(name = "apo_id_aporte", nullable = false)) })
	private DescargaId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apo_id_aporte", nullable = false, insertable = false, updatable = false)
	private Aporte aporte;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usu_id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	@Column(name = "des_fecha", nullable = false, length = 10)
	private Date fecha;

	public Descarga() {
	}

	public DescargaId getId() {
		return this.id;
	}

	public void setId(DescargaId id) {
		this.id = id;
	}

	public Aporte getAporte() {
		return this.aporte;
	}

	public void setAporte(Aporte aporte) {
		this.aporte = aporte;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}