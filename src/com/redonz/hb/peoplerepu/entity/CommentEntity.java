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
@Table(name = "comment", schema = "peoplerepu", catalog = "")
@IdClass(CommentEntityPK.class)
public class CommentEntity {
    private String id;
    private String comment;
    private Date commentedDate;
    private Time commentedTime;
    private String postId;
    private String commentor;

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 60)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "commented_date", nullable = false)
    public Date getCommentedDate() {
        return commentedDate;
    }

    public void setCommentedDate(Date commentedDate) {
        this.commentedDate = commentedDate;
    }

    @Basic
    @Column(name = "commented_time", nullable = false)
    public Time getCommentedTime() {
        return commentedTime;
    }

    public void setCommentedTime(Time commentedTime) {
        this.commentedTime = commentedTime;
    }

    @Id
    @Column(name = "Post_id", nullable = false, length = 100)
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "commentor", nullable = false, length = 100)
    public String getCommentor() {
        return commentor;
    }

    public void setCommentor(String commentor) {
        this.commentor = commentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (commentedDate != null ? !commentedDate.equals(that.commentedDate) : that.commentedDate != null)
            return false;
        if (commentedTime != null ? !commentedTime.equals(that.commentedTime) : that.commentedTime != null)
            return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (commentor != null ? !commentor.equals(that.commentor) : that.commentor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (commentedDate != null ? commentedDate.hashCode() : 0);
        result = 31 * result + (commentedTime != null ? commentedTime.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        result = 31 * result + (commentor != null ? commentor.hashCode() : 0);
        return result;
    }
}
