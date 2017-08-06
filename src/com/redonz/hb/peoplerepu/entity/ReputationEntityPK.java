package com.redonz.hb.peoplerepu.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
public class ReputationEntityPK implements Serializable {
    private String id;
    private String taskId;

    @Column(name = "id", nullable = false, length = 100)
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "Task_id", nullable = false, length = 100)
    @Id
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReputationEntityPK that = (ReputationEntityPK) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        return result;
    }
}
