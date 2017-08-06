package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "user_has_profession", schema = "peoplerepu", catalog = "")
@IdClass(UserHasProfessionEntityPK.class)
public class UserHasProfessionEntity {
    private String userId;
    private String professionId;

    @Id
    @Column(name = "User_id", nullable = false, length = 100)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "Profession_id", nullable = false, length = 30)
    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasProfessionEntity that = (UserHasProfessionEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (professionId != null ? !professionId.equals(that.professionId) : that.professionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (professionId != null ? professionId.hashCode() : 0);
        return result;
    }
}
