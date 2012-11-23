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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "busqueda_contexto", catalog = "goodluckdata")
@NamedQueries({ @NamedQuery(name = "BusquedaContexto.encontrarBusquedasConMayorNroVeces", query = "SELECT bc FROM BusquedaContexto bc WHERE bc.usuario=:usuario ") })
public class BusquedaContexto implements java.io.Serializable {

	private static final long serialVersionUID = 5915425324211113104L;
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idUsuario", column = @Column(name = "usu_id_usuario", nullable = false)),
			@AttributeOverride(name = "idEtiqueta", column = @Column(name = "eti_id_etiqueta", nullable = false)) })
	private BusquedaContextoId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eti_id_etiqueta", nullable = false, insertable = false, updatable = false)
	private Etiqueta etiqueta;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usu_id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	@Column(name = "bus_ultima_fecha", nullable = false, length = 10)
	private Date ultimaFecha;
	@Column(name = "bus_nro_veces", nullable = false, length = 10)
	private int nroVeces;
	private transient static final int peso=1;

	public int getPeso() {
		return peso;
	}
	
	public BusquedaContextoId getId() {
		return id;
	}

	public void setId(BusquedaContextoId id) {
		this.id = id;
	}

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getUltimaFecha() {
		return ultimaFecha;
	}

	public void setUltimaFecha(Date ultimaFecha) {
		this.ultimaFecha = ultimaFecha;
	}

	public int getNroVeces() {
		return nroVeces;
	}

	public void setNroVeces(int nroVeces) {
		this.nroVeces = nroVeces;
	}

}