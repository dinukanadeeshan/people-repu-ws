package com.redonz.hb.peoplerepu.controller;

import com.redonz.hb.peoplerepu.entity.UserEntity;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-12.
 * dinuka.nadeeshan1993@gmail.com
 */
public interface UserEntityController extends EntityController<Long, UserEntity> {
    public String authenticateUser(String userName, String password);
}

