package team.goodluck.modelo.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IAporteDao;
import team.goodluck.modelo.dao.IBusquedaContextoDao;
import team.goodluck.modelo.dao.IEtiquetaDao;
import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.BusquedaContexto;
import team.goodluck.modelo.objetosnegocio.BusquedaContextoId;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Service
public class SugerenciaServicio implements ISugerenciaServicio {

	@Autowired
	private IEtiquetaDao daoEtiqueta;
	@Autowired
	private IAporteDao daoAporte;
	@Autowired
	private IBusquedaContextoDao daoBusqueda;

	@Override
	@Transactional
	public List<Aporte> obtenerLoMasActual(Usuario usuario) {
		List<Etiqueta> busquedas = daoEtiqueta
				.encontrarEtiquetasBuscadas(daoBusqueda.encontrarBusquedasConMayorNroVeces(usuario));
		return daoAporte.encontrarAportesMasBuscados(busquedas);
	}

	@Override
	@Transactional
	public List<Aporte> obtenerLoMasVotado() {
		return daoAporte.encontrarAportesMasVotados();
	}
	
	@Override
	@Transactional
	public void registrarBusqueda(Usuario usuario, List<String> nombresEtiquetas) {
		List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
		for (String nombre : nombresEtiquetas) {
			registrarBusquedaContexto(usuario,daoEtiqueta.encontrarPorNombre(nombre));
		}
	}

	private BusquedaContexto registrarBusquedaContexto(Usuario usuario, Etiqueta etiqueta) {
		BusquedaContexto busqueda = new BusquedaContexto();
		Date fecha = new Date();
		busqueda.setId(new BusquedaContextoId(usuario.getId(), etiqueta.getId()));
		BusquedaContexto busquedaEncontrada = daoBusqueda.find(busqueda.getId());
		if (busquedaEncontrada== null) {
			busqueda.setUltimaFecha(fecha);
			return daoBusqueda.create(busqueda);
		} else {
			busquedaEncontrada.setNroVeces(busquedaEncontrada.getNroVeces() + 1);
			busquedaEncontrada.setUltimaFecha(fecha);
            return daoBusqueda.update(busquedaEncontrada);
		}
	}
	
}