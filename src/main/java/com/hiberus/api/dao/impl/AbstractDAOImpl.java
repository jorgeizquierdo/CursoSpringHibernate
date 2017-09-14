package com.hiberus.api.dao.impl;

import com.hiberus.api.dao.AbstractDAO;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
public abstract class AbstractDAOImpl<E> implements AbstractDAO<E> {

    public static final Logger log = LoggerFactory.getLogger(AbstractDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    private Class<E> entityClass;

    protected AbstractDAOImpl(Class<E> entityClass) {

        this.entityClass = entityClass;
    }

    @Override
    public Session getCurrentSession() {

        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Criteria getCriteria() {

        return this.getCurrentSession().createCriteria(this.entityClass);
    }

    @Override
    public E findById(int id) {

        return (E) getCurrentSession().get(this.entityClass, id);
    }

    @Override
    public Integer save(E e) {

        try {

            return (Integer) getCurrentSession().save(e);
        } catch (Exception ex) {

            log.error(ex.getMessage());
        }

        return null;
    }

    @Override
    public boolean update(E e) {

        try {

            getCurrentSession().update(e);
        } catch (Exception ex) {

            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean saveOrUpdate(E e) {

        try {

            getCurrentSession().saveOrUpdate(e);
        } catch (Exception ex) {

            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(E e) {

        try {

            getCurrentSession().delete(e);
        } catch (Exception ex) {

            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<E> findAll() {

        return getCurrentSession().createCriteria(this.entityClass).list();
    }

    @Override
    public List<E> findByCriteria(Criterion criterion) {

        Criteria criteria = getCurrentSession().createCriteria(this.entityClass);

        if (criterion != null) {
            criteria.add(criterion);
        }

        return criteria.list();
    }

    @Override
    public E findUniqueByCriteria(Criterion criterion) {

        Criteria criteria = getCurrentSession().createCriteria(this.entityClass);

        if (criterion != null) {
            criteria.add(criterion);
        }

        return (E) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    public List<E> findByHQL(String hql) {

        return this.getCurrentSession()
                .createQuery(hql)
                .list();
    }

    @Override
    public List<E> findByHQL(String hql, Object param) {

        return this.getCurrentSession()
                .createQuery(hql)
                .setParameter(0, param)
                .list();
    }

    @Override
    public List<E> findByHQL(String hql, List params) {

        Query query = this.getCurrentSession().createQuery(hql);

        for (int pos = 0; pos < params.size(); pos++) {

            query.setParameter(pos, params.get(pos));
        }

        return query.list();
    }

    @Override
    public E findUniqueByHQL(String hql) {

        return (E) this.getCurrentSession().createQuery(hql).setMaxResults(1).uniqueResult();
    }

    @Override
    public E findUniqueByHQL(String hql, Object param) {

        return (E) this.getCurrentSession()
                .createQuery(hql)
                .setParameter(0, param)
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public E findUniqueByHQL(String hql, List params) {

        Query query = this.getCurrentSession().createQuery(hql);

        for (int pos = 0; pos < params.size(); pos++) {

            query.setParameter(pos, params.get(pos));
        }

        return (E) query.setMaxResults(1).uniqueResult();
    }

    @Override
    public boolean existByHQL(String hql) {

        return !this.getCurrentSession().createQuery(hql).list().isEmpty();
    }

    @Override
    public boolean existByHQL(String hql, Object param) {

        return !this.getCurrentSession().createQuery(hql).setParameter(0, param).list().isEmpty();
    }

    @Override
    public boolean existByHQL(String hql, List params) {

        Query query = this.getCurrentSession().createQuery(hql);

        for (int pos = 0; pos < params.size(); pos++) {

            query.setParameter(pos, params.get(pos));
        }

        return !query.list().isEmpty();
    }

    /* NAMED QUERYS */

    @Override
    public List<E> sqlNamedQueryList(String namedQuery, Object[] values) {

        Query query = this.getCurrentSession().getNamedQuery(namedQuery);

        for (int pos = 0; pos < values.length; pos++) {

            query.setParameter(pos, values[pos]);
        }

        return (List<E>) query.list();
    }

    @Override
    public E sqlUniqueNamedQuery(String namedQuery, Object[] values) {

        Query query = this.getCurrentSession().getNamedQuery(namedQuery);

        for (int pos = 0; pos < values.length; pos++) {

            query.setParameter(pos, values[pos]);
        }

        return (E) query.setMaxResults(1).uniqueResult();
    }

	/* LAZY COLLECTIONS INITIALIZATION */

    @Override
    public E getUniqueFetchEntity(int id, String fetchProfileName) {

        this.getCurrentSession().enableFetchProfile(fetchProfileName);

        return (E) this.getCurrentSession()
                .createCriteria(this.entityClass)
                .add(Restrictions.idEq(id))
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public List<E> getFetchEntityList(String fetchProfileName) {

        this.getCurrentSession().enableFetchProfile(fetchProfileName);

        return (List<E>) this.getCurrentSession()
                .createCriteria(this.entityClass)
                .list();
    }

    @Override
    public E getUniqueLazyEntity(int id, CollectionName[] collectionsToBeInitialized) {

        Criteria criteria = this.getCurrentSession()
                .createCriteria(this.entityClass)
                .add(Restrictions.idEq(id))
                .setMaxResults(1);

        if (collectionsToBeInitialized != null && collectionsToBeInitialized.length > 0) {

            for (CollectionName collectionName : collectionsToBeInitialized) {

                criteria.setFetchMode(collectionName.getCollectionName(), FetchMode.JOIN);
            }
        }

        return (E) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    public E getUniqueLazyEntity(Criterion criterion, CollectionName[] collectionsToBeInitialized) {

        Criteria criteria = this.getCurrentSession()
                .createCriteria(this.entityClass)
                .add(criterion);

        if (collectionsToBeInitialized != null && collectionsToBeInitialized.length > 0) {

            for (CollectionName collectionName : collectionsToBeInitialized) {

                criteria.setFetchMode(collectionName.getCollectionName(), FetchMode.JOIN);
            }
        }

        return (E) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    public E getUniqueLazyEntity(Criteria criteria, CollectionName[] collectionsToBeInitialized) {

        if (collectionsToBeInitialized != null && collectionsToBeInitialized.length > 0) {

            for (CollectionName collectionName : collectionsToBeInitialized) {

                criteria.setFetchMode(collectionName.getCollectionName(), FetchMode.JOIN);
            }
        }

        return (E) criteria.setMaxResults(1).uniqueResult();
    }

    @Override
    public List<E> getLazyEntityList(Criterion criterion, CollectionName[] collectionsToBeInitialized) {

        Criteria criteria = this.getCriteria().add(criterion);

        if (collectionsToBeInitialized != null && collectionsToBeInitialized.length > 0) {

            for (CollectionName collectionName : collectionsToBeInitialized) {

                criteria.setFetchMode(collectionName.getCollectionName(), FetchMode.JOIN);
            }
        }

        return (List<E>) criteria.uniqueResult();
    }

    @Override
    public void clear() {

        this.getCurrentSession().clear();
    }

    @Override
    public void flush() {

        this.getCurrentSession().flush();
    }

}