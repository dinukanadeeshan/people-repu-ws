package com.redonz.hb.peoplerepu.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
public class UserHasProfessionEntityPK implements Serializable {
    private String userId;
    private String professionId;

    @Column(name = "User_id", nullable = false, length = 100)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "Profession_id", nullable = false, length = 30)
    @Id
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

        UserHasProfessionEntityPK that = (UserHasProfessionEntityPK) o;

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
