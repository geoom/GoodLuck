package team.goodluck.modelo.dao;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.BusquedaContexto;
import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IBusquedaContextoDao extends IGenericDao<BusquedaContexto>{

	List<BusquedaContexto> encontrarBusquedasConMayorNroVeces(Usuario usuario);
}