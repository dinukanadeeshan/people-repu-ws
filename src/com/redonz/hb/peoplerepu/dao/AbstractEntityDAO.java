/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.hb.peoplerepu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
public class AbstractEntityDAO<I, T> implements EntityDAO<I, T> {

    @PersistenceContext(unitName = "PeopleRepuPU")
    private EntityManager em;

    private Class<I> classI;
    private Class<T> classT;

    public AbstractEntityDAO(Class classI, Class classT) {
        this.classI = classI;
        this.classT = classT;
    }

    protected EntityManager getEntityManager() {

        return em;
    }

    @Override
    public void insert(T entity) {
//        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
//        getEntityManager().getTransaction().commit();
        System.out.println("Persitence - User added...------------------------------------------->");
    }

    @Override
    public void delete(I id) {
        T entity = getEntityManager().find(classT, id);

        getEntityManager().remove(entity);

    }

    @Override
    public void update(T entity) {
//        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
//        getEntityManager().getTransaction().commit();
    }

    @Override
    public T search(I id) {
        return getEntityManager().find(classT, id);
    }

    @Override
    public List<T> searchAll() {
        Query q = getEntityManager().createNamedQuery(classT.getSimpleName() + ".findAll");
        return q.getResultList();
    }

}
