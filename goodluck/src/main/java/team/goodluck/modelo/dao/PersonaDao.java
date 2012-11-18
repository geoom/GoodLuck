package team.goodluck.modelo.dao;

import org.springframework.stereotype.Repository;

import team.goodluck.modelo.objetosnegocio.Persona;
import team.goodluck.modelo.objetosnegocio.Usuario;

@Repository	
public class PersonaDao extends GenericDao<Persona> implements IPersonaDao{

}