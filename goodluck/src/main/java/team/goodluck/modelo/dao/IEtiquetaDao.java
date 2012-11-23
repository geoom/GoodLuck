package team.goodluck.modelo.dao;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.BusquedaContexto;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IEtiquetaDao extends IGenericDao<Etiqueta> {
	List<Etiqueta> encontrarEtiquetasBuscadas(List<BusquedaContexto> masBuscadas);

	List<Etiqueta> encontrarEtiquetasDescargadas(Usuario usuario);
}
