package com.redonz.hb.peoplerepu.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */
public class RequestEntityPK implements Serializable {
    private long sender;
    private long reciever;


    public RequestEntityPK(long sender, long reciever) {
        this.sender = sender;
        this.reciever = reciever;
    }

    @Column(name = "sender", nullable = false)
    @Id
    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    @Column(name = "reciever", nullable = false)
    @Id
    public long getReciever() {
        return reciever;
    }

    public void setReciever(long reciever) {
        this.reciever = reciever;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntityPK that = (RequestEntityPK) o;

        if (sender != that.sender) return false;
        if (reciever != that.reciever) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (sender ^ (sender >>> 32));
        result = 31 * result + (int) (reciever ^ (reciever >>> 32));
        return result;
    }
}
