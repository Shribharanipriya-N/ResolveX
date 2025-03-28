package com.application.ResolveX.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {

    private final Map<String,String> tokenStoreSessionHashmap = new HashMap<>();

    public String generateToken(String email){
        String token= UUID.randomUUID().toString();
        System.out.println("token generated"+token);
        tokenStoreSessionHashmap.put(email,token);
        return token;
    }

    public boolean isValidToken(String email,String token){
        if(tokenStoreSessionHashmap.containsKey(email)){
            System.out.println("email"+tokenStoreSessionHashmap.containsKey(email));
            System.out.println("token"+token.equalsIgnoreCase(tokenStoreSessionHashmap.get(email)));
            return token.equalsIgnoreCase(tokenStoreSessionHashmap.get(email));
        }
        return false;
    }
}
