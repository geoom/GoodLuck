package team.goodluck.modelo.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IPersonaDao;
import team.goodluck.modelo.dao.IUsuarioDao;
import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Service
public class RegistroServicio implements IRegistroServicio{
	@Autowired
	IPersonaDao daoPersona;
	@Autowired
	IUsuarioDao daoUsuario;

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