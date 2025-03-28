package com.application.ResolveX.auth;


import com.application.ResolveX.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    TokenService tokenService;

    @Override
    public  boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws IOException {

        if (req.getMethod().equalsIgnoreCase("OPTIONS")) {
            res.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        System.out.println("Prehandle called");
        System.out.println(req);
        String token=req.getHeader("Authorization");
        String email=req.getHeader("email");
        System.out.println(token+email);
        if(token==null  ||  email ==null || !tokenService.isValidToken(email,token)){
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Missing or Invalid Token");
            return false;
        }


        return true;
    }
}
