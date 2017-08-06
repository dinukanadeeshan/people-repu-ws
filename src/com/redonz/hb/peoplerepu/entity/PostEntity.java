package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "post", schema = "peoplerepu", catalog = "")
public class PostEntity {
    private String id;
    private String owner;
    private String decription;
    private Date postedDate;
    private Time postedTime;

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner", nullable = false, length = 100)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "decription", nullable = false, length = 45)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (decription != null ? !decription.equals(that.decription) : that.decription != null) return false;
        if (postedDate != null ? !postedDate.equals(that.postedDate) : that.postedDate != null) return false;
        if (postedTime != null ? !postedTime.equals(that.postedTime) : that.postedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (decription != null ? decription.hashCode() : 0);
        result = 31 * result + (postedDate != null ? postedDate.hashCode() : 0);
        result = 31 * result + (postedTime != null ? postedTime.hashCode() : 0);
        return result;
    }
}
