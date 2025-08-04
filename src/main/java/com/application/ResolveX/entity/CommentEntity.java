package com.application.ResolveX.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CommentDetails")
public class CommentEntity {
    @Override
    public String toString() {
        return "CommentEntity{" +
                "commentId=" + commentId +
                ", issue=" + issue +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", commentedAt=" + commentedAt +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "issue_id", referencedColumnName ="issueId")
    private IssueEntity issue;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;

    private String content;
    private Date commentedAt;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public IssueEntity getIssue() {
        return issue;
    }

    public void setIssue(IssueEntity issue) {
        this.issue = issue;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(Date commentedAt) {
        this.commentedAt = commentedAt;
    }


}
