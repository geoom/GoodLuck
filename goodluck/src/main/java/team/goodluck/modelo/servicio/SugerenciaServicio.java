package team.goodluck.modelo.servicio;

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
	private IEtiquetaDao etiquetaDao;
	@Autowired
	private IAporteDao aporteDao;
	@Autowired
	private IBusquedaContextoDao busquedaDao;

	@Override
	@Transactional
	public List<Aporte> obtenerLoMasActual(Usuario usuario) {
		List<Etiqueta> busquedas = etiquetaDao
				.encontrarEtiquetasBuscadas(busquedaDao.encontrarBusquedasConMayorNroVeces(usuario));
		return aporteDao.encontrarAportesMasBuscados(busquedas);
	}

	@Override
	@Transactional
	public List<Aporte> obtenerLoMasVotado(Usuario usuario) {
		return aporteDao.encontrarAportesMasVotados();
	}
	
	@Override
	@Transactional
	public BusquedaContexto registrarBusqueda(Usuario usuario, Etiqueta etiqueta) {
		BusquedaContexto busqueda = new BusquedaContexto();
		Date fecha = new Date();
		busqueda.setId(new BusquedaContextoId(usuario.getId(), etiqueta.getId()));
		BusquedaContexto busquedaEncontrada = busquedaDao.find(busqueda.getId());
		if (busquedaEncontrada== null) {
			busqueda.setUltimaFecha(fecha);
			return busquedaDao.create(busqueda);
		} else {
			busquedaEncontrada.setNroVeces(busquedaEncontrada.getNroVeces() + 1);
			busquedaEncontrada.setUltimaFecha(fecha);
            return busquedaDao.update(busquedaEncontrada);
		}
	}

}