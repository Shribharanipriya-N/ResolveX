package com.application.ResolveX.service;


import com.application.ResolveX.entity.CommentEntity;
import com.application.ResolveX.entity.IssueEntity;
import com.application.ResolveX.entity.UserEntity;
import com.application.ResolveX.repository.CommentRepository;
import com.application.ResolveX.repository.IssueRepository;
import com.application.ResolveX.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IssueRepository issueRepository;


    public List<CommentEntity> getComments(Integer issueId) {

        return commentRepository.findAllByIssue_IssueId(issueId);
    }




    public CommentEntity createComment(UserEntity user, IssueEntity issue, String content) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentedAt(new Date());
        commentEntity.setContent(content);

        UserEntity existingUser = userRepository.findById(user.getUserId()).orElseThrow();
        IssueEntity existingIssue = issueRepository.findById(issue.getIssueId()).orElseThrow();

        commentEntity.setUser(existingUser);
        commentEntity.setIssue(existingIssue);

        return commentRepository.save(commentEntity);
    }

}
