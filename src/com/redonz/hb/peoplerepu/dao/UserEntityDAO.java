package com.redonz.hb.peoplerepu.dao;

import com.redonz.hb.peoplerepu.entity.UserEntity;
import com.redonz.hb.peoplerepu.entity.UserHasProfessionEntity;
import com.redonz.hb.peoplerepu.entity.UserHasSkillEntity;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-12.
 * dinuka.nadeeshan1993@gmail.com
 */

public interface UserEntityDAO extends EntityDAO<Long, UserEntity> {
    boolean authenticateUser(String userName, String password);

    void addSkill(UserHasSkillEntity userHasSkillEntity);

    void addProfession(UserHasProfessionEntity userHasProfessionEntity);
}

