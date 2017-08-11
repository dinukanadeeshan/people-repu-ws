package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "user_has_skill", schema = "peoplerepu", catalog = "")
@IdClass(UserHasSkillEntityPK.class)
public class UserHasSkillEntity {
    private long peopleId;
    private int skillId;

    @Id
    @Column(name = "People_id", nullable = false)
    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    @Id
    @Column(name = "Skill_id", nullable = false)
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

        UserHasSkillEntity that = (UserHasSkillEntity) o;

        if (peopleId != that.peopleId) return false;
        if (skillId != that.skillId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (peopleId ^ (peopleId >>> 32));
        result = 31 * result + skillId;
        return result;
    }
}
