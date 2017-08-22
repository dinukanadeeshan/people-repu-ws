package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.UpdateEntityDAO;
import com.redonz.hb.peoplerepu.entity.UpdateEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class UpdateEntityDAOImpl extends AbstractEntityDAO<Long, UpdateEntity> implements UpdateEntityDAO {
    public UpdateEntityDAOImpl() {
        super(Long.class, UpdateEntity.class);
    }
}
