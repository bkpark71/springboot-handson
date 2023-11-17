package com.example.sample1.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceMeasure {
    //*.*(..) service 패키지 아래의 모든 클래스 안에 있는 모든 메서드 로 줄 수 있다.
    @Around("execution(* com.example.sample1.service.PostService.*(..))")
    public Object measurePerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info(String.format("%s - Method 의 실행시간은 , Time: %d ms 입니다.", pjp.getSignature().getName(), end - start));
        return result;
    }
}
