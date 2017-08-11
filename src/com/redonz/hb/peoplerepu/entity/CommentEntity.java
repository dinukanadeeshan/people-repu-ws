package com.redonz.hb.peoplerepu.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Project - PeopleRepuWS
 * Created by Dinuka Nadeeshan on 2017-08-11.
 * dinuka.nadeeshan1993@gmail.com
 */
@Entity
@Table(name = "comment", schema = "peoplerepu", catalog = "")
@IdClass(CommentEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "CommentEntity.findAll", query = "SELECT u FROM CommentEntity u")
})
public class CommentEntity {
    private long id;
    private String comment;
    private Date commentedDate;
    private Time commentedTime;
    private long postId;
    private long commentor;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 1000)
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
    @Column(name = "Post_id", nullable = false)
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "commentor", nullable = false)
    public long getCommentor() {
        return commentor;
    }

    public void setCommentor(long commentor) {
        this.commentor = commentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (postId != that.postId) return false;
        if (commentor != that.commentor) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (commentedDate != null ? !commentedDate.equals(that.commentedDate) : that.commentedDate != null)
            return false;
        if (commentedTime != null ? !commentedTime.equals(that.commentedTime) : that.commentedTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (commentedDate != null ? commentedDate.hashCode() : 0);
        result = 31 * result + (commentedTime != null ? commentedTime.hashCode() : 0);
        result = 31 * result + (int) (postId ^ (postId >>> 32));
        result = 31 * result + (int) (commentor ^ (commentor >>> 32));
        return result;
    }
}
