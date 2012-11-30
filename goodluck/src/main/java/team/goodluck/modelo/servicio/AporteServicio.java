package team.goodluck.modelo.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IAporteDao;
import team.goodluck.modelo.dao.IEtiquetaDao;
import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Service
public class AporteServicio implements IAporteServicio {

	@Autowired
	private IAporteDao daoAporte;

	@Autowired
	private IEtiquetaDao daoEtiqueta;

	@Override
	@Transactional
	public List<Aporte> encontrarAportesPorContextoTitulo(String titulo,
			List<String> etiquetas) {
		List<Aporte> aportes;
		if (titulo.equals(" ")) {
			aportes = daoAporte.encontrarAportes(etiquetas);
		} else {
			aportes = daoAporte.encontrarAportes(titulo, etiquetas);
		}
		return aportes;
	}

	@Override
	@Transactional
	public List<Aporte> encontrarAportesDeUsuario(Usuario usuario) {
		return daoAporte.encontrarAportes(usuario);
	}
	
	@Override
	@Transactional
	public Aporte registrarAporte(Aporte aporte, List<String> nombresEtiquetas) {
		List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
		for (String nombre : nombresEtiquetas) {
			etiquetas.add(daoEtiqueta.encontrarPorNombre(nombre));
		}
		aporte.setFechaEntrada(new Date());
		aporte.setEtiquetas(etiquetas);
		return daoAporte.create(aporte);
	}

	@Override
	@Transactional
	public Aporte actualizarAporte(Aporte aporte) {
		return daoAporte.update(aporte);
	}

	@Override
	@Transactional
	public void actualizarVotosAporte(Aporte aporte){
	 aporte.setVotos(aporte.getVotos()+1);
	 daoAporte.update(aporte);
	}
	
}