package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.TaskEntityDAO;
import com.redonz.hb.peoplerepu.entity.TaskEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class TaskEntityDAOImpl extends AbstractEntityDAO<Long, TaskEntity> implements TaskEntityDAO {
    public TaskEntityDAOImpl() {
        super(Long.class, TaskEntity.class);
    }
}
