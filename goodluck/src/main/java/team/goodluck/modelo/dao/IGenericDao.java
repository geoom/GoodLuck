package team.goodluck.modelo.dao;

import java.util.List;
import java.util.Map;

public interface IGenericDao< T > {
    
	/**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @param params
     *            sql parameters
     * @return the number of records meeting the criteria
     */
    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);   
    
    List<T> findByNamedQuery(String namedQuery);
    
    List<T> findByNamedQuery(String namedQuery, Map parameters);
    
    List<T> findByNamedQuery(String namedQuery, int limit);
    
    List<T> findByNamedQuery(String namedQuery, Map parameters, int limit);
    
    T findSingleResultByNamedQuery(String namedQuery, Map parameters);
}