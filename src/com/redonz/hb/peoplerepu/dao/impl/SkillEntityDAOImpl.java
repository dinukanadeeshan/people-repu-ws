package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.SkillEntityDAO;
import com.redonz.hb.peoplerepu.entity.SkillEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */

@WebService(serviceName = "UserWebService")
@Stateless
public class SkillEntityDAOImpl extends AbstractEntityDAO<Long, SkillEntity> implements SkillEntityDAO {
    public SkillEntityDAOImpl() {
        super(Long.class, SkillEntity.class);
    }
}
