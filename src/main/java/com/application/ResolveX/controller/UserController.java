package com.application.ResolveX.controller;

import com.application.ResolveX.entity.UserEntity;
import com.application.ResolveX.repository.UserRepository;
import com.application.ResolveX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public boolean checkCredentialInDatabase(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    public UserEntity registerUser(String email, String password,String name) {
        if (userRepository.findByEmail(email).isPresent()) {
            return null;
        }
        UserEntity newUser = new UserEntity();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }
    @GetMapping("/user/id")
    public ResponseEntity<?> getUserId(@RequestHeader("email") String email) {
        try {
            Optional<UserEntity> user = userService.getUserByEmail(email);
            System.out.println(user);
            if (user.isPresent()) {
                System.out.println(user.get().getUserId());
                return ResponseEntity.ok(user.get().getUserId());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/user")
    public ResponseEntity<?> getUserDetails(@RequestHeader Integer id){
        try{
            UserEntity user=userService.getUserDetails(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
