package team.goodluck.modelo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import team.goodluck.modelo.objetosnegocio.BusquedaContexto;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Repository
public class EtiquetaDao extends GenericDao<Etiqueta> implements IEtiquetaDao{

	@Override
	public List<Etiqueta> encontrarEtiquetasBuscadas(List<BusquedaContexto> masBuscadas){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("masBuscadas", masBuscadas);
		return (List<Etiqueta>)findByNamedQuery("Etiqueta.encontrarEtiquetasBuscadas", mapa, 5);	
	}
	
	@Override
	public List<Etiqueta> encontrarEtiquetasDescargadas(Usuario usuario){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("usuario", usuario);
		return (List<Etiqueta>)findByNamedQuery("Etiqueta.encontrarEtiquetasDescargadas", mapa);	
	}
	
}
