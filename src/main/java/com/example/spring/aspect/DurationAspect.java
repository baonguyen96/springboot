package com.example.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DurationAspect {
    @Around("@annotation(com.example.spring.aspect.Duration)")
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = pjp.proceed();
        long endTime = System.currentTimeMillis();

        log.info("Class Name: {}. Method Name: {}. Time taken for Execution is : {}ms",
                pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), endTime - startTime);

        return object;
    }
}
