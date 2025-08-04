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


    public IssueEntity deleteIssue(Integer issueId,Integer id) {
        IssueEntity issue = issueRepository.findByIssueId(issueId);

        if (issue == null) {
            throw new RuntimeException("Issue Not Found");
        }

        boolean valid=id.equals(issue.getAssignedBy());
        if(valid) {
            issueRepository.deleteById(issueId);
            return issue;
        }
        else throw new RuntimeException("Can't Delete");
    }

    public IssueEntity updateIssueStatus(Integer issueId,Integer id){
        IssueEntity ExistingIssue=issueRepository.findByIssueId(issueId);
        if(ExistingIssue==null) throw new RuntimeException("No Issue Found");
        boolean isValid=id.equals(ExistingIssue.getAssignedTo());
        if(isValid){
                ExistingIssue.setStatus(true);
            LocalDate currentDate = LocalDate.now();
                ExistingIssue.setResolvedAt(currentDate);
                issueRepository.save(ExistingIssue);
                return ExistingIssue;
        }
        throw new RuntimeException("Cant Update");
    }

    public IssueEntity getIssue(Integer issueId) {
        IssueEntity issue = issueRepository.findByIssueId(issueId);

        if (issue == null) {
            throw new RuntimeException("Issue Not Found");
        }
        else
            return issue;
    }
}
