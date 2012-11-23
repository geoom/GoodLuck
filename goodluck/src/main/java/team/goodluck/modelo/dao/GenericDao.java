package team.goodluck.modelo.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(defaultRollback = false)
public abstract class GenericDao<T> implements IGenericDao<T> {

	@PersistenceContext
	protected EntityManager em;
	private Class<T> type;

	public GenericDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T create(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public void delete(final Object id) {
		em.remove(this.em.getReference(type, id));
	}

	@Override
	public T find(final Object id) {
		return (T) em.find(type, id);
	}

	@Override
	public T update(final T t) {
		return em.merge(t);
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery) {
		Query query = em.createNamedQuery(namedQuery);
		return query.getResultList();
	}
	@Override
	public List<T> findByNamedQuery(String namedQuery, Map parameters) {
		Query query = em.createNamedQuery(namedQuery);
		setParameters(query, parameters);
		return query.getResultList();
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery, int limit) {
		Query query = em.createNamedQuery(namedQuery);
		return query.setMaxResults(limit).getResultList();
	}
	
	@Override
	public List<T> findByNamedQuery(String namedQuery, Map parameters, int limit) {
		Query query = em.createNamedQuery(namedQuery);
		setParameters(query, parameters);
		return query.setMaxResults(limit).getResultList();
	}
	
	@Override
	public T findSingleResultByNamedQuery(String namedQuery, Map parameters) {
		Query query = em.createNamedQuery(namedQuery);
		setParameters(query, parameters);
		T obj = null;
		obj = (T) query.getSingleResult();
		return obj;
	}

	private void setParameters(Query query, Map parameters) {
		Set<Object> keys = (Set<Object>) parameters.keySet();
		for (Object key : keys) {
			query.setParameter(key.toString(), parameters.get(key));
		}
	}

}