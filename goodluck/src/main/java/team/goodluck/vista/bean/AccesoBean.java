package team.goodluck.vista.bean;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAccesoServicio;

@Controller
@Scope("session")
public class AccesoBean implements java.io.Serializable {

	private static final long serialVersionUID = -7209403056095508087L;
	static final Logger log = Logger.getLogger(AccesoBean.class);
	private Usuario usuario;
	private String nombre;
	private String clave;
	private Boolean identificado;
	private Boolean falloLogin;

	@Autowired
	private IAccesoServicio accesoServicio;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		identificado = Boolean.FALSE;
		falloLogin = Boolean.FALSE;
	}

	public String solicitarAcceso() {
		String destino = "";
		usuario.setNombre(nombre);
		usuario.setClave(clave);
		usuario = accesoServicio.validarIdentidad(usuario);
		if (usuario.getId() != null) {
			destino = "home.xhtml";
			identificado = Boolean.TRUE;
			falloLogin = Boolean.FALSE;
			log.debug("Usuario identificado: Redirigiendo a " + destino);
		} else {
			destino = "identificacion.xhtml";
			falloLogin = Boolean.TRUE;
			log.debug("Usuario NO identificado: Redirigiendo a " + destino);
		}
		clean();
		return destino;
	}

	public void clean() {
		nombre = "";
		clave = "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getFalloLogin() {
		return falloLogin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
