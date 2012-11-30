package team.goodluck.modelo.servicio;

import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IAccesoServicio {
	Usuario validarIdentidad(Usuario usuario);
}