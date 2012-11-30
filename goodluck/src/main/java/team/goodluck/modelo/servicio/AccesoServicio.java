package team.goodluck.modelo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IUsuarioDao;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Service
public class AccesoServicio implements IAccesoServicio {

	@Autowired
	private IUsuarioDao daoUsuario;

	@Override
	@Transactional(readOnly = true)
	public boolean validarIdentidad(Usuario usuario) {
		Usuario usuarioIdentificado = null;
		try{
		usuarioIdentificado=daoUsuario.encontrarUsuario(usuario.getNombre(), usuario.getClave());
		}catch(org.springframework.dao.EmptyResultDataAccessException ex){
			System.out.println("No existe el usuario.");
		}
		if (usuarioIdentificado != null){
			usuario=usuarioIdentificado;
			return true;
		}
		return false;
	}

}