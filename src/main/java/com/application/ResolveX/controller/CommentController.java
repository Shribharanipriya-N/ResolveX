package com.application.ResolveX.controller;

import com.application.ResolveX.entity.CommentEntity;
import com.application.ResolveX.entity.IssueEntity;
import com.application.ResolveX.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments/{id}")

    public ResponseEntity<?> getComments(@PathVariable("id") Integer issueId){
        try{
            List<CommentEntity> commentEntities=commentService.getComments(issueId);
            return ResponseEntity.status(HttpStatus.OK).body(commentEntities);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addComment(@RequestBody CommentEntity commentEntity){
        System.out.println(commentEntity);
      try{
          CommentEntity savedComment = commentService.createComment(commentEntity.getUser(),commentEntity.getIssue(),commentEntity.getContent());

          return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
      } catch (Exception e) {

          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
      }
    }
}
