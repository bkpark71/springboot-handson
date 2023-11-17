package com.example.sample1.config;

import com.example.sample1.service.UserService;
//import com.example.sample1.util.LoginFailureHandler;
//import com.example.sample1.util.LoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserService userService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/user/login", "/user/join", "/user/check").permitAll()
                .anyRequest().authenticated();
        // 인증 필요시 로그인 페이지와 로그인 성공시 리다이랙팅 경로 지정
        http
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("userId")
                .passwordParameter("pwd")
                // 로그인이 수행될 uri 매핑 (post 요청)
                .loginProcessingUrl("/user/login")
                .successForwardUrl("/posts")
                .failureForwardUrl("/user/login");
        // logout
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/user/login");
        http.userDetailsService(userService);
        return http.build();
    }
}