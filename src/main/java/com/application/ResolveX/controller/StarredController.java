package com.application.ResolveX.controller;


import com.application.ResolveX.entity.StarredEntity;
import com.application.ResolveX.service.StarredService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarredController {

    @Autowired
    StarredService starredService;


    @GetMapping("/issue/starred")
    public ResponseEntity<?> getStarredIssue(@RequestParam Integer id){
        try{
            List<StarredEntity> starredIssue= starredService.getStarredIssue(id);
            return ResponseEntity.status(HttpStatus.OK).body(starredIssue);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/issue/starred")
    public ResponseEntity<?> addStarredIssue(@RequestBody StarredEntity starredEntity){
        return ResponseEntity.status(HttpStatus.OK).body(starredService.addStarredIssue(starredEntity));
    }

    @DeleteMapping("/issue/starred/{id}")
    public ResponseEntity<?> deleteStarredIssue(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(starredService.deleteStarredIssue(id));
        }
        catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
