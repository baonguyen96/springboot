package com.example.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    // https://www.baeldung.com/spring-aop-pointcut-tutorial
    @Pointcut("execution(* com.example.spring.controller.*.*(..))")
    private void controllerPointcut() {}

    @Before(value = "controllerPointcut()")
    public void endpointBefore(JoinPoint p) {
        log.info("Executing {}.{}({})", p.getSignature().getDeclaringTypeName(), p.getSignature().getName(), p.getArgs());
    }
}
