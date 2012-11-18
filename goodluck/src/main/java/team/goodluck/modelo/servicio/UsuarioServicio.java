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
	public boolean autentificar(Map<String, String> datosUsuario) {
		String nombreEsperado = "gmejia";
		String claveEsperado = "sistemas";

		System.out.println(nombreEsperado + " :: " + claveEsperado);
		boolean habilitado = Boolean.TRUE;
		if (nombreEsperado.equals(datosUsuario.get("nombre").toString())
				&& claveEsperado.equals(datosUsuario.get("clave").toString())
				&& habilitado) {
			return true;
		}
		return false;
	}

	@Override
    @Transactional
	public void crearUsuario(String nombre, String clave) {
		Persona p=new Persona();
		p.setApellidoPaterno("asd");
		p.setApellidoMaterno("aa");
		p.setNombre("s");
		p.setCorreoElectronico("s");
		p.setSexo('M');
		p.setFechaNacimiento(new Date());
		daoPersona.create(p);
		Usuario u=new Usuario();
		u.setNombre(nombre);
		u.setClave(clave);
		u.setPersona(p);
		daoUsuario.create(u);
	}
	
	@Override
    @Transactional
	public Usuario registrarUsuario(Usuario usuarioACrear, Persona personaSolicitante){
		daoPersona.create(personaSolicitante);
		usuarioACrear.setPersona(personaSolicitante);
		return daoUsuario.create(usuarioACrear);
	}
	
}