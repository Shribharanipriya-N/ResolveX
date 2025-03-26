package com.application.ResolveX.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "StarredIssues")
public class StarredEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer starredId;
    @ManyToOne
    @JoinColumn(name = "UserEntity" ,referencedColumnName = "userId")
    private UserEntity user;

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

    public Integer getStarredId() {
        return starredId;
    }

    public void setStarredId(Integer starredId) {
        this.starredId = starredId;
    }

    @ManyToOne
    @JoinColumn(name = "IssueEntity", referencedColumnName = "issueId")
    private IssueEntity issue;


    public StarredEntity(Integer starredId, UserEntity user, IssueEntity issue) {
        this.starredId = starredId;
        this.user = user;
        this.issue = issue;
    }

    public StarredEntity() {
    }
}
