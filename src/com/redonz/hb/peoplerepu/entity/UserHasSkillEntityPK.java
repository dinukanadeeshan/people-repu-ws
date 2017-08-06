package com.redonz.hb.peoplerepu.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-06.
 * dinuka.nadeeshan1993@gmail.com
 */
public class UserHasSkillEntityPK implements Serializable {
    private String peopleId;
    private int skillId;

    @Column(name = "People_id", nullable = false, length = 100)
    @Id
    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    @Column(name = "Skill_id", nullable = false)
    @Id
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasSkillEntityPK that = (UserHasSkillEntityPK) o;

        if (skillId != that.skillId) return false;
        if (peopleId != null ? !peopleId.equals(that.peopleId) : that.peopleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = peopleId != null ? peopleId.hashCode() : 0;
        result = 31 * result + skillId;
        return result;
    }
}
