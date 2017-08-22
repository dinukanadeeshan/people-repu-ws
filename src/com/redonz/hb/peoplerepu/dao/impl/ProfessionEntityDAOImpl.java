package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.ProfessionEntityDAO;
import com.redonz.hb.peoplerepu.entity.ProfessionEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class ProfessionEntityDAOImpl extends AbstractEntityDAO<Long, ProfessionEntity> implements ProfessionEntityDAO {
    public ProfessionEntityDAOImpl() {
        super(Long.class, ProfessionEntity.class);
    }
}
