package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "post", schema = "peoplerepu", catalog = "")
public class PostEntity {
    private long id;
    private long owner;
    private String decription;
    private Date postedDate;
    private Time postedTime;
    private byte isTask;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner", nullable = false)
    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "decription", nullable = false, length = 1000)
    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Basic
    @Column(name = "posted_date", nullable = false)
    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Basic
    @Column(name = "posted_time", nullable = false)
    public Time getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Time postedTime) {
        this.postedTime = postedTime;
    }

    @Basic
    @Column(name = "is_task", nullable = false)
    public byte getIsTask() {
        return isTask;
    }

    public void setIsTask(byte isTask) {
        this.isTask = isTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (id != that.id) return false;
        if (owner != that.owner) return false;
        if (isTask != that.isTask) return false;
        if (decription != null ? !decription.equals(that.decription) : that.decription != null) return false;
        if (postedDate != null ? !postedDate.equals(that.postedDate) : that.postedDate != null) return false;
        if (postedTime != null ? !postedTime.equals(that.postedTime) : that.postedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (owner ^ (owner >>> 32));
        result = 31 * result + (decription != null ? decription.hashCode() : 0);
        result = 31 * result + (postedDate != null ? postedDate.hashCode() : 0);
        result = 31 * result + (postedTime != null ? postedTime.hashCode() : 0);
        result = 31 * result + (int) isTask;
        return result;
    }
}
