package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "task", schema = "peoplerepu", catalog = "")
public class TaskEntity {
    private long taskId;
    private long giver;
    private long taker;
    private Date date;

    @Id
    @Column(name = "Task_id", nullable = false)
    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "giver", nullable = false)
    public long getGiver() {
        return giver;
    }

    public void setGiver(long giver) {
        this.giver = giver;
    }

    @Basic
    @Column(name = "taker", nullable = false)
    public long getTaker() {
        return taker;
    }

    public void setTaker(long taker) {
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

        if (taskId != that.taskId) return false;
        if (giver != that.giver) return false;
        if (taker != that.taker) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (taskId ^ (taskId >>> 32));
        result = 31 * result + (int) (giver ^ (giver >>> 32));
        result = 31 * result + (int) (taker ^ (taker >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
