package team.goodluck.modelo.servicio;

import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IAccesoServicio {
	 boolean validarIdentidad(String nombre, String clave);
}