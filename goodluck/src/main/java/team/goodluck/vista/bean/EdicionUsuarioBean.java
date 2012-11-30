package team.goodluck.vista.bean;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IUsuarioServicio;

@Controller
@Scope("request")
public class EdicionUsuarioBean implements java.io.Serializable {

	private static final long serialVersionUID = -3923366379030054239L;
	static final Logger log = Logger.getLogger(EdicionUsuarioBean.class);
	private Usuario usuario;
	private Persona persona;
	@Autowired
	private IUsuarioServicio usuarioServicio;
	@Autowired
	@Qualifier("accesoBean")
	private AccesoBean accesoBean;

	@PostConstruct
	public void init() {
		usuario = accesoBean.getUsuario();
		persona = accesoBean.getUsuario().getPersona();
	}

	public String editarUsuario() {
		usuarioServicio.actualizarUsuario(usuario, persona);
		accesoBean.setUsuario(usuario);
		return "home.xhtml";
	}

	public String cancelar() {
		return "home.xmtl";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
