package team.goodluck.modelo.objetosnegocio;

import javax.persistence.Embeddable;

@Embeddable
public class BusquedaContextoId implements java.io.Serializable{

	private static final long serialVersionUID = -4916893490839336838L;
	private int idUsuario;
	private int idEtiqueta;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdEtiqueta() {
		return idEtiqueta;
	}
	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}
		
	
}