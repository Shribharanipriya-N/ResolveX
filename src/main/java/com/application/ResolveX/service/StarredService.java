package com.application.ResolveX.service;


import com.application.ResolveX.entity.IssueEntity;
import com.application.ResolveX.entity.StarredEntity;
import com.application.ResolveX.entity.UserEntity;
import com.application.ResolveX.repository.IssueRepository;
import com.application.ResolveX.repository.StarredRepository;
import com.application.ResolveX.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StarredService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssueRepository issueRepository;

   @Autowired
   StarredRepository starredRepository;

   @Autowired
   UserService userService;
    public List<StarredEntity> getStarredIssue(Integer id) {

        UserEntity user=userService.getUserDetails(id);
        List<StarredEntity> list= starredRepository.findByUser(user);
        if(!list.isEmpty()){
            return list;
        }
        throw new RuntimeException("No Starred Issues");
    }

    public StarredEntity addStarredIssue(StarredEntity starredEntity){
        UserEntity user = userRepository.findById(starredEntity.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        IssueEntity issue = issueRepository.findById(starredEntity.getIssue().getIssueId())
                .orElseThrow(() -> new RuntimeException("Issue Not Found"));

        StarredEntity starredEntity1 = new StarredEntity();
        starredEntity1.setUser(user);
        starredEntity1.setIssue(issue);
        return starredRepository.save(starredEntity1);
    }

    public StarredEntity deleteStarredIssue(Integer userId,Integer issueId) {

        Optional<StarredEntity> starredEntity = starredRepository.findByIssue_IssueIdAndUser_UserId(issueId, userId);
        if (starredEntity.isPresent()) {
            starredRepository.deleteById(starredEntity.get().getStarredId());
            return starredEntity.get();
        }
        throw new RuntimeException("Not Starred");

    }
}
