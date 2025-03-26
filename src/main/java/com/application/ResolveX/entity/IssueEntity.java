package com.application.ResolveX.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "IssueDetails")
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;
    private Integer assignedTo;
    private  Integer assignedBy;
    private Boolean status;
    private String description;
    private String issueName;
    private LocalDate createdAt;
    private LocalDate resolvedAt;

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Integer getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Integer assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDate resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
//    private boolean starred;
}
