package com.example.sample1.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Logging {

    @Before("execution(* com.example.sample1.service.PostService.*(..))")
    public void leavinglog(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String className = jp.getTarget().getClass().getName();
        log.info(" {} - {} 가 실행되기 전 남긴 로그", className, methodName);
    }
}
