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

	Usuario registrarUsuario(Usuario usuarioACrear, Persona personaSolicitante);
}