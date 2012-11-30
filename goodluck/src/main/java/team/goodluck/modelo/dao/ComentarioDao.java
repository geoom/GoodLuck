package team.goodluck.modelo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Comentario;

@Repository	
public class ComentarioDao extends GenericDao<Comentario> implements IComentarioDao{

	@Override
	public List<Comentario> encontrarComentarios(Aporte aporte){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("aporte", aporte);	
		return (List<Comentario>)findByNamedQuery("Comentario.encontrarComentariosPorAporte", mapa);
	}
	
}