package com.application.ResolveX.controller;


import com.application.ResolveX.entity.IssueEntity;
import com.application.ResolveX.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class IssueController {

    @Autowired
    IssueService issueService;

    @PostMapping("/issue")
    public ResponseEntity<?> createIssue(@RequestBody IssueEntity issueEntity){
         IssueEntity issue=issueService.createIssue(issueEntity.getAssignedTo(),issueEntity.getAssignedBy(),issueEntity.getDescription(),issueEntity.getIssueName());
         return ResponseEntity.status(HttpStatus.OK).body(issue);
    }

    @GetMapping("/issues")
    public ResponseEntity<?> getAllIssues(){
        try{
            List<IssueEntity> issues=issueService.getAllIssues();
            return ResponseEntity.status(HttpStatus.OK).body(issues);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/issueToMe/{userId}")
    public ResponseEntity<?> getAllIssuesOfUser(@PathVariable Integer userId){
        try{
            List<IssueEntity> issues=issueService.getIssuesOfUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body(issues);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/issueByMe/{userId}")
    public ResponseEntity<?> getUserCreatedIssues(@PathVariable Integer userId){
        try{
            List<IssueEntity> issues=issueService.getUserCreatedIssues(userId);
            return ResponseEntity.status(HttpStatus.OK).body(issues);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
