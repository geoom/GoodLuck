package team.goodluck.vista.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.servicio.IUsuarioServicio;

@Controller
@Scope("session")
public class UsuarioBean implements Serializable {

	static final Logger log = Logger.getLogger(UsuarioBean.class);
	private static final long serialVersionUID = 1900209508848559649L;
	private String clave;
	private Boolean habilitado;
	private String nombre;

	@Autowired
	private IUsuarioServicio usuarioServicio;

	@PostConstruct
	public void init() {
		habilitado = Boolean.TRUE;
	}

	public void actionIdentificarUsuario() {

		Map<String, String> datosRecogidos = new HashMap<String, String>();
		datosRecogidos.put("nombre", nombre);
		datosRecogidos.put("clave", clave);

		if (usuarioServicio.autentificar(datosRecogidos)) {
			log.debug("usuario identificado !");
		}else{
			log.debug("usuario NO identificado !!");
		}
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
