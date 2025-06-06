package com.application.ResolveX.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CommentDetails")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "IssueEntity",referencedColumnName ="issueId" )
    private IssueEntity issue;

    @ManyToOne
    @JoinColumn(name = "UserEntity",referencedColumnName = "userId")
    private UserEntity user;
    private String content;
    private Date commentedAt;

}
