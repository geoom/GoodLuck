package team.goodluck.modelo.servicio;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IRegistroServicio {
	void crearUsuario(String nombre, String clave);
	Usuario registrarUsuario(Usuario usuarioSolicitante, Persona personaSolicitante);
}