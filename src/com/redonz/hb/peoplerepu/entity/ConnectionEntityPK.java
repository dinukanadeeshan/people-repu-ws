package com.redonz.hb.peoplerepu.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
public class ConnectionEntityPK implements Serializable {
    private String user1;
    private String user2;

    @Column(name = "user1", nullable = false, length = 100)
    @Id
    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    @Column(name = "user2", nullable = false, length = 100)
    @Id
    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionEntityPK that = (ConnectionEntityPK) o;

        if (user1 != null ? !user1.equals(that.user1) : that.user1 != null) return false;
        if (user2 != null ? !user2.equals(that.user2) : that.user2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user1 != null ? user1.hashCode() : 0;
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        return result;
    }
}
