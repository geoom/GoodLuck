package team.goodluck.modelo.servicio;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;


/**
 * 
 * @author GEORGE MEJIA
 */
public interface IUsuarioServicio {

	boolean autentificar(Map<String, String> datosUsuario);
	
	Usuario registrarUsuario(Usuario usuarioACrear, Persona personaSolicitante);
	
	void crearUsuario(String nombre, String clave);
}