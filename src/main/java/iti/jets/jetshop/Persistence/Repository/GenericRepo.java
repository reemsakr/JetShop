package iti.jets.jetshop.Persistence.Repository;

import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

public abstract class  GenericRepo <T,ID extends Serializable> implements GenericRepoInt<T,ID> {
    protected Class<T> persistentClass;
    protected ID idClass;
    protected final EntityManager entityManager;

    public GenericRepo(Class<T> persistentClass, ID idClass, EntityManager entityManager){
        this.persistentClass = persistentClass;
        this.idClass = idClass;
        this.entityManager = entityManager ;
    }
    public List<T> findAll() {
        return entityManager.createQuery( "from " + persistentClass.getName(), persistentClass )
                .getResultList();
    }

    public T findById(ID id) {
        return entityManager.find(persistentClass,id);
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(ID id) {
        T entity = findById(id);
        delete(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }
}
