package com.hiberus.api.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
public interface AbstractDAO<E> {

    Session getCurrentSession();

    Criteria getCriteria();

    Integer save(E e);

    boolean update(E e);

    boolean saveOrUpdate(E e);

    boolean delete(E e);

    E findById(int id);

    List<E> findAll();

    List<E> findByCriteria(Criterion criterion);

    E findUniqueByCriteria(Criterion criterion);

    List<E> findByHQL(String hql);

    List<E> findByHQL(String hql, Object param);

    List<E> findByHQL(String hql, List<?> params);

    E findUniqueByHQL(String hql);

    E findUniqueByHQL(String hql, Object param);

    E findUniqueByHQL(String hql, List<?> params);

    boolean existByHQL(String hql);

    boolean existByHQL(String hql, Object param);

    boolean existByHQL(String hql, List<?> params);

    /* NAMED QUERYS */

    List<E> sqlNamedQueryList(String namedQuery, Object[] values);

    E sqlUniqueNamedQuery(String namedQuery, Object[] values);

	/* LAZY COLLECTIONS INITIALIZATION */

    E getUniqueFetchEntity(int id, String fetchProfileName);

    List<E> getFetchEntityList(String fetchProfileName);

    E getUniqueLazyEntity(int id, CollectionName[] collectionsToBeInitialized);

    E getUniqueLazyEntity(Criterion criterion, CollectionName[] collectionsToBeInitialized);

    E getUniqueLazyEntity(Criteria criteria, CollectionName[] collectionsToBeInitialized);

    List<E> getLazyEntityList(Criterion criterion, CollectionName[] collectionsToBeInitialized);

    void clear();

    void flush();

    interface CollectionName {

        String getCollectionName();

    }

}
