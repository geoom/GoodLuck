package team.goodluck.modelo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import team.goodluck.modelo.objetosnegocio.BusquedaContexto;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Repository
public class BusquedaContextoDao extends GenericDao<BusquedaContexto> implements IBusquedaContextoDao{

	@Override
	public List<BusquedaContexto> encontrarBusquedasConMayorNroVeces(Usuario usuario){
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("usuario", usuario);
		return (List<BusquedaContexto>)findByNamedQuery("BusquedaContexto.encontrarBusquedasConMayorNroVeces", mapa, 5);	

	}
	
}