package team.goodluck.modelo.objetosnegocio;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relacion", catalog = "goodluckdata")
public class Relacion {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idEtiqueta", column = @Column(name = "eti_id_etiqueta", nullable = false)),
			@AttributeOverride(name = "idAporte", column = @Column(name = "apo_id_aporte", nullable = false)) })
	private RelacionId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apo_id_aporte", nullable = false, insertable = false, updatable = false)
	private Aporte aporte;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eti_id_etiqueta", nullable = false, insertable = false, updatable = false)
	private Etiqueta etiqueta;
	public RelacionId getId() {
		return id;
	}
	public void setId(RelacionId id) {
		this.id = id;
	}
	public Aporte getAporte() {
		return aporte;
	}
	public void setAporte(Aporte aporte) {
		this.aporte = aporte;
	}
	public Etiqueta getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}
	
}
