package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "update", schema = "peoplerepu", catalog = "")
@NamedQueries({
        @NamedQuery(name = "UpdateEntity.findAll", query = "SELECT u FROM UpdateEntity u")
})
public class UpdateEntity {
    private long id;
    private Date updatedDate;
    private String description;
    private long taskId;
    private long userId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "updated_date", nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Task_id", nullable = false)
    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "User_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateEntity that = (UpdateEntity) o;

        if (id != that.id) return false;
        if (taskId != that.taskId) return false;
        if (userId != that.userId) return false;
        if (updatedDate != null ? !updatedDate.equals(that.updatedDate) : that.updatedDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (taskId ^ (taskId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }
}
