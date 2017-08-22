package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "user_has_profession", schema = "peoplerepu", catalog = "")
@IdClass(UserHasProfessionEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "UserHasProfessionEntity.findAll", query = "SELECT u FROM UserHasProfessionEntity u")
})
public class UserHasProfessionEntity {
    private long userId;
    private long professionId;

    @Id
    @Column(name = "User_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "Profession_id", nullable = false)
    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasProfessionEntity that = (UserHasProfessionEntity) o;

        if (userId != that.userId) return false;
        if (professionId != that.professionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (professionId ^ (professionId >>> 32));
        return result;
    }
}
