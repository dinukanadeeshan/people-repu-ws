package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "task", schema = "peoplerepu", catalog = "")
public class TaskEntity {
    private String id;
    private String giver;
    private String taker;
    private Date date;

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "giver", nullable = false, length = 100)
    public String getGiver() {
        return giver;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    @Basic
    @Column(name = "taker", nullable = false, length = 100)
    public String getTaker() {
        return taker;
    }

    public void setTaker(String taker) {
        this.taker = taker;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (giver != null ? !giver.equals(that.giver) : that.giver != null) return false;
        if (taker != null ? !taker.equals(that.taker) : that.taker != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (giver != null ? giver.hashCode() : 0);
        result = 31 * result + (taker != null ? taker.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
