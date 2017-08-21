package com.redonz.hb.peoplerepu.dao;

import com.redonz.hb.peoplerepu.entity.UserEntity;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-12.
 * dinuka.nadeeshan1993@gmail.com
 */

public interface UserEntityDAO extends EntityDAO<Long, UserEntity> {
    public String authenticateUser(String userName, String password);
}

