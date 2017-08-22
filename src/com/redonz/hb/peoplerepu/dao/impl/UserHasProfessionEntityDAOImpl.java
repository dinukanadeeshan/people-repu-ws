package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.UserHasProfessionEntityDAO;
import com.redonz.hb.peoplerepu.entity.UserHasProfessionEntity;
import com.redonz.hb.peoplerepu.entity.UserHasProfessionEntityPK;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class UserHasProfessionEntityDAOImpl extends AbstractEntityDAO<UserHasProfessionEntityPK, UserHasProfessionEntity> implements UserHasProfessionEntityDAO {
    public UserHasProfessionEntityDAOImpl() {
        super(UserHasProfessionEntityPK.class, UserHasProfessionEntity.class);
    }
}
