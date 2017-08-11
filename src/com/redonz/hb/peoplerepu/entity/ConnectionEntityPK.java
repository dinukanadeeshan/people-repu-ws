package com.redonz.hb.peoplerepu.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
public class ConnectionEntityPK implements Serializable {
    private long user1;
    private long user2;

    @Column(name = "user1", nullable = false)
    @Id
    public long getUser1() {
        return user1;
    }

    public void setUser1(long user1) {
        this.user1 = user1;
    }

    @Column(name = "user2", nullable = false)
    @Id
    public long getUser2() {
        return user2;
    }

    public void setUser2(long user2) {
        this.user2 = user2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionEntityPK that = (ConnectionEntityPK) o;

        if (user1 != that.user1) return false;
        if (user2 != that.user2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (user1 ^ (user1 >>> 32));
        result = 31 * result + (int) (user2 ^ (user2 >>> 32));
        return result;
    }
}
