package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "connection", schema = "peoplerepu", catalog = "")
@IdClass(ConnectionEntityPK.class)
public class ConnectionEntity {
    private String user1;
    private String user2;
    private String recomendedPeople;
    private Date startedDate;

    @Id
    @Column(name = "user1", nullable = false, length = 100)
    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    @Id
    @Column(name = "user2", nullable = false, length = 100)
    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Basic
    @Column(name = "recomended_people", nullable = true, length = 100)
    public String getRecomendedPeople() {
        return recomendedPeople;
    }

    public void setRecomendedPeople(String recomendedPeople) {
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

        if (user1 != null ? !user1.equals(that.user1) : that.user1 != null) return false;
        if (user2 != null ? !user2.equals(that.user2) : that.user2 != null) return false;
        if (recomendedPeople != null ? !recomendedPeople.equals(that.recomendedPeople) : that.recomendedPeople != null)
            return false;
        if (startedDate != null ? !startedDate.equals(that.startedDate) : that.startedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user1 != null ? user1.hashCode() : 0;
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (recomendedPeople != null ? recomendedPeople.hashCode() : 0);
        result = 31 * result + (startedDate != null ? startedDate.hashCode() : 0);
        return result;
    }
}
