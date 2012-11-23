package team.goodluck.vista.bean;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IUsuarioServicio;

@Controller
@Scope("request")
public class RegistroBean implements java.io.Serializable {

	private static final long serialVersionUID = 3858698246634823588L;
	static final Logger log = Logger.getLogger(RegistroBean.class);
	private Persona persona;
	private Usuario usuario;
	@Autowired
	private IUsuarioServicio usuarioServicio;

	@PostConstruct
	public void init() {
		persona = new Persona();
		usuario = new Usuario();
	}

	public String registrarUsuario() {
		usuarioServicio.registrarUsuario(usuario, persona);
		log.debug("Usuario creado: " + usuario.getId());
		return "index.xhtml";
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
