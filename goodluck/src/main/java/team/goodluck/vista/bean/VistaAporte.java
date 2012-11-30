package team.goodluck.vista.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAporteServicio;
import team.goodluck.modelo.servicio.IComentarioServicio;

@Controller
@Scope("view")
public class VistaAporte implements java.io.Serializable {

	private static final long serialVersionUID = -3420957399390427151L;
	static final Logger log = Logger.getLogger(VistaAporte.class);
	private Aporte aporte;
	private Usuario usuario;
	private String comentario;

	@Autowired
	private IComentarioServicio comentarioServicio;
	@Autowired
	private IAporteServicio aporteServicio;

	public void descargarAporte() {

	}

	public void hacerComentario() {
		comentarioServicio.registrarComentario(usuario, aporte, comentario);
	}

	public void destacarAporte(){
		aporteServicio.actualizarVotosAporte(aporte);
	}
	
	public Aporte getAporte() {
		return aporte;
	}

	public void setAporte(Aporte aporte) {
		this.aporte = aporte;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
