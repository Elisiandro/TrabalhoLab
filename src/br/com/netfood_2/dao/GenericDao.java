package br.com.netfood_2.dao;

import br.com.netfood_2.util.JpaUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDao<T, I extends Serializable> {

    protected EntityManager entityManager;

    private Class<T> persistedClass;

    protected GenericDao() {
    }

    protected GenericDao(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }

    public T salvar(T entity) {
        entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        return entity;
    }

    public T atualizar(T entity) {
        entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        return entity;
    }

    public void remover(I id) {
        T entity = encontrar(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
        entityManager.flush();
        tx.commit();
    }

    public List<T> getList() {
        entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return entityManager.createQuery(query).getResultList();
    }

    public T encontrar(I id) {
        entityManager = JpaUtil.getEntityManager();
        return entityManager.find(persistedClass, id);
    }
}
