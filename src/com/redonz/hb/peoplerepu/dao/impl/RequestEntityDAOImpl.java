package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.RequestEntityDAO;
import com.redonz.hb.peoplerepu.entity.RequestEntity;
import com.redonz.hb.peoplerepu.entity.RequestEntityPK;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class RequestEntityDAOImpl extends AbstractEntityDAO<RequestEntityPK, RequestEntity> implements RequestEntityDAO {
    public RequestEntityDAOImpl() {
        super(RequestEntityPK.class, RequestEntity.class);
    }
}
