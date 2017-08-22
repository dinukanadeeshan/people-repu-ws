package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.ConnectionEntityDAO;
import com.redonz.hb.peoplerepu.entity.ConnectionEntity;
import com.redonz.hb.peoplerepu.entity.ConnectionEntityPK;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */
@WebService(serviceName = "UserWebService")
@Stateless
public class ConnectionEntityDAOImpl extends AbstractEntityDAO<ConnectionEntityPK, ConnectionEntity> implements ConnectionEntityDAO {
    public ConnectionEntityDAOImpl() {
        super(ConnectionEntityPK.class, ConnectionEntity.class);
    }
}
