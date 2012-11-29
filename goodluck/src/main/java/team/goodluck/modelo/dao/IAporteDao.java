package team.goodluck.modelo.dao;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Etiqueta;

public interface IAporteDao extends IGenericDao<Aporte>{

	List<Aporte> encontrarAportes(String titulo, List<String> etiquetas);
	List<Aporte> encontrarAportes(List<String> etiquetas);
	List<Aporte> encontrarAportesMasBuscados(List<Etiqueta> etiquetas);
	List<Aporte> encontrarAportesMasVotados();
}