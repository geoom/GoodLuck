package team.goodluck.modelo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Repository
public class AporteDao extends GenericDao<Aporte> implements IAporteDao {

	@Override
	public List<Aporte> encontrarAportes(String titulo, List<String> etiquetas){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("etiquetas", etiquetas);	
		mapa.put("titulo", titulo);
		return (List<Aporte>)findByNamedQuery("Aporte.encontrarAportesPorTituloEtiquetas", mapa, 12);
	}
	
	@Override
	public List<Aporte> encontrarAportes(List<String> etiquetas){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("etiquetas", etiquetas);	
		return (List<Aporte>)findByNamedQuery("Aporte.encontrarAportesPorEtiquetas", mapa, 12);
	}
	
	@Override
	public List<Aporte> encontrarAportes(Usuario usuario){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("usuario", usuario);	
		return (List<Aporte>)findByNamedQuery("Aporte.encontrarAportesDeUsuario", mapa);
	}
	
	
	@Override
	public List<Aporte> encontrarAportesMasBuscados(List<Etiqueta> etiquetas){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("etiquetas", etiquetas);	
		return (List<Aporte>)findByNamedQuery("Aporte.encontrarAportesMasBuscados", mapa, 5);
	}
	
	@Override
	public List<Aporte> encontrarAportesMasVotados(){
		return (List<Aporte>)findByNamedQuery("Aporte.encontrarAportesMasVotados",5);
	}
}