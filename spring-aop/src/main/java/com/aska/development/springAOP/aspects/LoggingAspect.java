package com.aska.development.springAOP.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.aska.development.*.*.StudentDao.*(int))")
    public void studentDaoAccessLog(JoinPoint joinPoint){
        System.out.println("Student dao access log...");
        System.out.println(joinPoint.getSignature().getName());
    }
}
