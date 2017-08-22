package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.ReputationEntityDAO;
import com.redonz.hb.peoplerepu.entity.ReputationEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class ReputationEntityDAOImpl extends AbstractEntityDAO<Long, ReputationEntity> implements ReputationEntityDAO {
    public ReputationEntityDAOImpl() {
        super(Long.class, ReputationEntity.class);
    }
}
