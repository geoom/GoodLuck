package team.goodluck.modelo.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Etiqueta;

@Repository
public class AporteDao extends GenericDao<Aporte> implements IAporteDao {

	public List<Aporte> encontrarAportes(String titulo, String... etiquetas){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("etiquetas", Arrays.asList(etiquetas));	
		mapa.put("titulo", titulo);
		return (List<Aporte>)findByNamedQuery("Aporte.encontrarAportesContexto", mapa);
	}
	
}