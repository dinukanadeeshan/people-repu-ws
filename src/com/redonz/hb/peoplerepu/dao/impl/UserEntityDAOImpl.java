package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.UserEntityDAO;
import com.redonz.hb.peoplerepu.entity.UserEntity;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-12.
 * dinuka.nadeeshan1993@gmail.com
 */
@WebService(serviceName = "UserWebService")
//@Named
@Stateless
public class UserEntityDAOImpl extends AbstractEntityDAO<Long, UserEntity> implements UserEntityDAO {

    public UserEntityDAOImpl() {
        super(Long.class, UserEntity.class);
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public boolean authenticateUser(String userName, String password) {
        Query q = getEntityManager().createQuery("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.password = :password");
        q.setParameter("userName", userName);
        q.setParameter("password", password);
        try {
            Object rst = q.getSingleResult();
            if (rst == null) {
                return false;
            }
            return true;
        } catch (NoResultException ex) {
            return false;
        } catch (NonUniqueResultException ex) {
            return true;
        }
    }


//    @Override
//    public List<User> getUsersByJob(String jobId) {
//        getEntityManager().createQuery("SELECT u FROM User u, Job j WHERE  j.jobId = u")
//    }
//
}

