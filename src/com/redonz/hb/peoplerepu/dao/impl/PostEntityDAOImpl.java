package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.PostEntityDAO;
import com.redonz.hb.peoplerepu.entity.PostEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-21.
 * dinuka.nadeeshan1993@gmail.com
 */
@WebService(serviceName = "UserWebService")
//@Named
@Stateless
public class PostEntityDAOImpl extends AbstractEntityDAO<Long, PostEntity> implements PostEntityDAO {
    public PostEntityDAOImpl() {
        super(Long.class, PostEntity.class);
    }
}
