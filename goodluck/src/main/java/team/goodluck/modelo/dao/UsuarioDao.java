package team.goodluck.modelo.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Repository
public class UsuarioDao extends GenericDao<Usuario> implements IUsuarioDao {

	@Override
	public Usuario encontrarUsuario(String nombre, String clave) {
		Map<String, Object> mapa = new HashMap<String, Object>();
		Usuario usuarioEncontrado = null;
		mapa.put("nombre", nombre);
		mapa.put("clave", clave);
		usuarioEncontrado = (Usuario) findSingleResultByNamedQuery(
				"Usuario.encontrarUsuario", mapa);
		return usuarioEncontrado;
	}

}