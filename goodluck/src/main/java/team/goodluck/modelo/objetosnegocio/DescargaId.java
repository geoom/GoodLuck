package team.goodluck.modelo.objetosnegocio;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DescargaId implements java.io.Serializable {

	private static final long serialVersionUID = 1663308790438460789L;

	private int idUsuario;
	private int idAporte;

	public DescargaId() {
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

		return (this.getIdUsuario() == castOther.getIdUsuario())
				&& (this.getIdAporte() == castOther.getIdAporte());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + this.getIdUsuario();
		result = 37 * result + this.getIdAporte();
		return result;
	}

}
