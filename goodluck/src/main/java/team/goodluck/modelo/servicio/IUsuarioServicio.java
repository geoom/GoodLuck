package team.goodluck.modelo.servicio;

import java.util.Map;

import team.goodluck.modelo.objetosnegocio.Usuario;


/**
 * 
 * @author GEORGE MEJIA
 */
public interface IUsuarioServicio {

	boolean autentificar(Map<String, String> datosUsuario);

	Usuario cargar();

}
