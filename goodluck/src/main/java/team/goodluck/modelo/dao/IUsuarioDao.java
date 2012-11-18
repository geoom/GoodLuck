package team.goodluck.modelo.dao;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario>{
	Usuario encontrarUsuario(String nombre, String clave);
}