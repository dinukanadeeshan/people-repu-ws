package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "reputation", schema = "peoplerepu", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ReputationEntity.findAll", query = "SELECT u FROM ReputationEntity u")
})
public class ReputationEntity {
    private long id;
    private int points;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReputationEntity that = (ReputationEntity) o;

        if (id != that.id) return false;
        if (points != that.points) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + points;
        return result;
    }
}
