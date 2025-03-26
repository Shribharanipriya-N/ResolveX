package com.application.ResolveX.service;


import com.application.ResolveX.entity.IssueEntity;
import com.application.ResolveX.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepository;


    public List<IssueEntity> getAllIssues(){
        List<IssueEntity> issues=issueRepository.findAll();
        System.out.println(issues);
        if(!issues.isEmpty()){
            return issues;
        }
        throw new RuntimeException("No Issues Found");
    }

    public IssueEntity createIssue(Integer assignedTo,Integer assignedBy, String description, String name){
        IssueEntity newIssue=new IssueEntity();
        newIssue.setAssignedTo(assignedTo);
        newIssue.setAssignedBy(assignedBy);
        newIssue.setStatus(false);
        newIssue.setDescription(description);
        newIssue.setIssueName(name);
        LocalDate currentDate = LocalDate.now();
        newIssue.setCreatedAt( currentDate);
        issueRepository.save(newIssue);
        return newIssue;
    }

    public List<IssueEntity> getIssuesOfUser(Integer userId){
        List<IssueEntity> issues=issueRepository.findByAssignedTo(userId);
        if(!issues.isEmpty()){
            return issues;
        }
        throw new RuntimeException("No Issues Found");
    }

    public List<IssueEntity> getUserCreatedIssues(Integer userId){
        List<IssueEntity> issues=issueRepository.findByAssignedBy(userId);
        if(!issues.isEmpty()){
            return issues;
        }
        throw new RuntimeException("No Issues Found");
    }


    public IssueEntity deleteIssue(Integer issueId) {

        IssueEntity issue=issueRepository.findByIssueId(issueId);
        if(issue!=null)
            return issue;
        throw new RuntimeException("Issue Not Found");
    }
}
