package com.redonz.hb.peoplerepu.dao.impl;

import com.redonz.hb.peoplerepu.dao.AbstractEntityDAO;
import com.redonz.hb.peoplerepu.dao.CommentEntityDAO;
import com.redonz.hb.peoplerepu.entity.CommentEntity;
import com.redonz.hb.peoplerepu.entity.CommentEntityPK;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-21.
 * dinuka.nadeeshan1993@gmail.com
 */
@WebService(serviceName = "UserWebService")
@Stateless
public class CommentEntityDAOImpl extends AbstractEntityDAO<CommentEntityPK, CommentEntity> implements CommentEntityDAO {
    public CommentEntityDAOImpl() {
        super(CommentEntityPK.class, CommentEntity.class);
    }
}
