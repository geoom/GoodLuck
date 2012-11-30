package team.goodluck.modelo.servicio;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Comentario;
import team.goodluck.modelo.objetosnegocio.Usuario;


public interface IComentarioServicio {
	List<Comentario> encontrarComentarios(Aporte aporte);
	Comentario registrarComentario(Usuario usuario, Aporte aporte, String contenido);
}
