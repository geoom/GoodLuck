package team.goodluck.vista.bean;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAccesoServicio;

@Controller
@Scope("session")
public class AccesoBean implements java.io.Serializable{

	private static final long serialVersionUID = -7209403056095508087L;
	static final Logger log = Logger.getLogger(AccesoBean.class);
    private Usuario usuario;
	@Autowired
	private IAccesoServicio accesoServicio;
    
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	public String validarIdentidad() {
		String destino="";
		if (accesoServicio.validarIdentidad(usuario.getNombre(), usuario.getClave())) {
			destino="home.xhtml";
			log.debug("Usuario identificado: Redirigiendo a "+destino);
		} else {
			destino="identificacion.xhtml";
			log.debug("Usuario NO identificado: Redirigiendo a "+destino);
		}
	 	
		return destino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}