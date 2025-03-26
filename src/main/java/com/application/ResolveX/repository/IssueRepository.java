package com.application.ResolveX.repository;

import com.application.ResolveX.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IssueRepository extends JpaRepository<IssueEntity,Integer> {
    List<IssueEntity> findByAssignedTo(Integer userId);

    List<IssueEntity> findByAssignedBy(Integer userId);

    IssueEntity findByIssueId(Integer issueId);
}
