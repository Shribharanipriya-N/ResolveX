package com.application.ResolveX.controller;



import com.application.ResolveX.dto.AuthResponse;
import com.application.ResolveX.repository.UserRepository;
import com.application.ResolveX.service.TokenService;
import com.application.ResolveX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/login")

    public ResponseEntity<?>  login (@RequestHeader String email,@RequestHeader String password){
        boolean isValid=userService.checkCredentialInDatabase(email,password);
        if(isValid){
            String token=tokenService.generateToken(email);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AuthResponse(email, token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestHeader String email, @RequestHeader String password, @RequestHeader String name) {
        if (userService.registerUser(email, password,name) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
    }
}
