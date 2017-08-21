/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redonz.hb.peoplerepu.dao;

import java.util.List;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
public interface EntityDAO<I, T> {
    void insert(T entity);

    void delete(I id);

    void update(T entity);

    T search(I id);

    List<T> searchAll();
}
