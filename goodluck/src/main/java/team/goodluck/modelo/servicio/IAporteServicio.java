package team.goodluck.modelo.servicio;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Usuario;

public interface IAporteServicio {
	List<Aporte> encontrarAportesPorContextoTitulo(String titulo,
			List<String> etiquetas);

	Aporte registrarAporte(Aporte aporte, List<String> nombresEtiquetas);

	Aporte actualizarAporte(Aporte aporte);

	void actualizarVotosAporte(Aporte aporte);
	
	List<Aporte> encontrarAportesDeUsuario(Usuario usuario);
}