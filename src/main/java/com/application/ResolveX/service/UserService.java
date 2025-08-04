package com.application.ResolveX.service;

import com.application.ResolveX.entity.UserEntity;
import com.application.ResolveX.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

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
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setName(name);
        System.out.print(newUser);
        return userRepository.save(newUser);
    }

    public UserEntity getUserDetails(Integer id) {
        Optional<UserEntity> user=userRepository.findByUserId(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new RuntimeException("User Not Found");
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
