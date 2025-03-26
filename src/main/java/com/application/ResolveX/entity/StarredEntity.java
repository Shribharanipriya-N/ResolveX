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
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "IssueEntity", referencedColumnName = "issueId")
    private IssueEntity issueId;
}
