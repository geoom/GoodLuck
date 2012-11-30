package team.goodluck.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IComentarioDao;
import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Comentario;
import team.goodluck.modelo.objetosnegocio.Usuario;
@Service
public class ComentarioServicio {

	@Autowired
	private IComentarioDao daoComentario;
	
	@Transactional
	public List<Comentario> encontrarComentarios(Aporte aporte){
		return daoComentario.encontrarComentarios(aporte);
	}
	
	@Transactional
	public Comentario registrarComentario(Usuario usuario, Aporte aporte, String contenido){
		Comentario comentario=new Comentario();
		comentario.setContenido(contenido);
		comentario.setUsuario(usuario);
		comentario.setAporte(aporte);
		return daoComentario.create(comentario);
	}
	
}
