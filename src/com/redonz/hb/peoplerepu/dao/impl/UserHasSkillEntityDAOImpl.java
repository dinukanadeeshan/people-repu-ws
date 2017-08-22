package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.UserHasSkillEntityDAO;
import com.redonz.hb.peoplerepu.entity.UserHasSkillEntity;
import com.redonz.hb.peoplerepu.entity.UserHasSkillEntityPK;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class UserHasSkillEntityDAOImpl extends AbstractEntityDAO<UserHasSkillEntityPK, UserHasSkillEntity> implements UserHasSkillEntityDAO {
    public UserHasSkillEntityDAOImpl() {
        super(UserHasSkillEntityPK.class, UserHasSkillEntity.class);
    }
}
