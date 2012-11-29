package team.goodluck.modelo.servicio;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IPersonaDao;
import team.goodluck.modelo.dao.IUsuarioDao;
import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;

/**
 * 
 * @author GEORGE MEJIA
 */
@Service
public class UsuarioServicio implements IUsuarioServicio, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	IPersonaDao daoPersona;
	@Autowired
	IUsuarioDao daoUsuario;

	@Override
	@Transactional
	public Usuario registrarUsuario(Usuario usuarioACrear,
			Persona personaSolicitante) {
		daoPersona.create(personaSolicitante);
		usuarioACrear.setPersona(personaSolicitante);
		return daoUsuario.create(usuarioACrear);
	}

}