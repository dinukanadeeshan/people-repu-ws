package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "connection", schema = "peoplerepu", catalog = "")
@IdClass(ConnectionEntityPK.class)
public class ConnectionEntity {
    private long user1;
    private long user2;
    private Long recomendedPeople;
    private Date startedDate;

    @Id
    @Column(name = "user1", nullable = false)
    public long getUser1() {
        return user1;
    }

    public void setUser1(long user1) {
        this.user1 = user1;
    }

    @Id
    @Column(name = "user2", nullable = false)
    public long getUser2() {
        return user2;
    }

    public void setUser2(long user2) {
        this.user2 = user2;
    }

    @Basic
    @Column(name = "recomended_people", nullable = true)
    public Long getRecomendedPeople() {
        return recomendedPeople;
    }

    public void setRecomendedPeople(Long recomendedPeople) {
        this.recomendedPeople = recomendedPeople;
    }

    @Basic
    @Column(name = "started_date", nullable = false)
    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionEntity that = (ConnectionEntity) o;

        if (user1 != that.user1) return false;
        if (user2 != that.user2) return false;
        if (recomendedPeople != null ? !recomendedPeople.equals(that.recomendedPeople) : that.recomendedPeople != null)
            return false;
        if (startedDate != null ? !startedDate.equals(that.startedDate) : that.startedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (user1 ^ (user1 >>> 32));
        result = 31 * result + (int) (user2 ^ (user2 >>> 32));
        result = 31 * result + (recomendedPeople != null ? recomendedPeople.hashCode() : 0);
        result = 31 * result + (startedDate != null ? startedDate.hashCode() : 0);
        return result;
    }
}
