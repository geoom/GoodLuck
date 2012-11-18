package team.goodluck.modelo.servicio;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;

public interface IAporteServicio {
	List<Aporte> encontrarAportesPorContextoTitulo(String titulo, String... etiquetas);

	Aporte registrarAporte(Aporte aporte);
}