package com.example.sample1.util;


//import com.example.sample1.model.User;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        HttpSession session = request.getSession();
//        User user = (User) authentication.getPrincipal();
//        session.setAttribute("greeting", authentication.getName() + "님 반갑습니다.");
//        session.setAttribute("user", user);
//        Object user1 = session.getAttribute("user");
//        User user2 = (User) session.getAttribute("user");
//        response.sendRedirect("/posts");
//    }
//
//    @Override
//    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
//    }
//}
