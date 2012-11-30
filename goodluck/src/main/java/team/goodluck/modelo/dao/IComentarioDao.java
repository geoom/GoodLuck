package team.goodluck.modelo.dao;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Comentario;

public interface IComentarioDao extends IGenericDao<Comentario> {

	List<Comentario> encontrarComentarios(Aporte aporte);
}