package team.goodluck.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.goodluck.modelo.dao.IAporteDao;
import team.goodluck.modelo.objetosnegocio.Aporte;

@Service
public class AporteServicio implements IAporteServicio {

	@Autowired
	IAporteDao daoAporte;

	@Transactional
	public List<Aporte> encontrarAportesPorContextoTitulo(String titulo, String... etiquetas) {
     return daoAporte.encontrarAportes(titulo, etiquetas);
	}

	@Transactional
	public Aporte registrarAporte(Aporte aporte){
	 return daoAporte.create(aporte);
	}
	
}