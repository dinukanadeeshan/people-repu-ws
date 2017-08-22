package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-22.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "request", schema = "peoplerepu", catalog = "")
@IdClass(RequestEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "RequestEntity.findAll", query = "SELECT u FROM RequestEntity u")
})
public class RequestEntity {
    private long sender;
    private long reciever;

    @Id
    @Column(name = "sender", nullable = false)
    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    @Id
    @Column(name = "reciever", nullable = false)
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

        RequestEntity that = (RequestEntity) o;

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
