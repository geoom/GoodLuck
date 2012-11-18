package team.goodluck.modelo.dao;

import java.util.List;

import team.goodluck.modelo.objetosnegocio.Aporte;

public interface IAporteDao extends IGenericDao<Aporte>{

	List<Aporte> encontrarAportes(String titulo, String... etiquetas);
}