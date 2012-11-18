package team.goodluck.modelo.objetosnegocio;

import javax.persistence.Embeddable;

@Embeddable
public class RelacionId implements java.io.Serializable{


	private static final long serialVersionUID = -1558370248940394970L;

	private int idEtiqueta;
	private int idAporte;
	
	public int getIdEtiqueta() {
		return idEtiqueta;
	}
	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}
	public int getIdAporte() {
		return idAporte;
	}
	public void setIdAporte(int idAporte) {
		this.idAporte = idAporte;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DescargaId))
			return false;
		DescargaId castOther = (DescargaId) other;

		return (this.getIdEtiqueta() == castOther.getIdUsuario())
				&& (this.getIdAporte() == castOther.getIdAporte());
	}

	public int hashCode() {
		int result = 18;
		result = 37 * result + this.getIdEtiqueta();
		result = 37 * result + this.getIdAporte();
		return result;
	}
	
	
}
