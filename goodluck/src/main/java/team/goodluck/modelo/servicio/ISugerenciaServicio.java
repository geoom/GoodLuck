package team.goodluck.modelo.servicio;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.BusquedaContexto;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

public interface ISugerenciaServicio {
	List<Aporte> obtenerLoMasActual(Usuario usuario);
	List<Aporte> obtenerLoMasVotado(Usuario usuario);
	BusquedaContexto registrarBusqueda(Usuario usuario, Etiqueta etiqueta);
}
