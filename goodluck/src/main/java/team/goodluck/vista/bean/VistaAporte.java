package team.goodluck.vista.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Comentario;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAporteServicio;
import team.goodluck.modelo.servicio.IComentarioServicio;

@Controller
@Scope("session")
public class VistaAporte implements java.io.Serializable {

	private static final long serialVersionUID = -3420957399390427151L;
	static final Logger log = Logger.getLogger(VistaAporte.class);
	private Aporte aporte;
	private String comentario;
	private List<Comentario> comentarios;
	
	@Autowired
	@Qualifier("resultadosBean")
	private ResultadosBean resultadosBean;
	@Autowired
	@Qualifier("accesoBean")
	private AccesoBean accesoBean;

	@Autowired
	private IComentarioServicio comentarioServicio;
	@Autowired
	private IAporteServicio aporteServicio;

	@PostConstruct
	public void init() {
		aporte=resultadosBean.getAporteSeleccionado();
		cargarComentarios();
	}

	public void descargarAporte() {

	}

	public void hacerComentario() {
		comentarioServicio.registrarComentario(accesoBean.getUsuario(), aporte, comentario);
	}

	public void destacarAporte() {
		aporteServicio.actualizarVotosAporte(aporte);
	}

	private void cargarComentarios() {
		comentarios = comentarioServicio.encontrarComentarios(aporte);
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
