package com.codesnippet.ecom.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.codesnippet.ecom.Service.*.*(..))") // the pointcut expression
    private void anyOldTransfer() {}

    @Around("anyOldTransfer()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect log called");
        //method/jointpoint call
        Object result = joinPoint.proceed();
        System.out.println("Aspect after log called");
        return result;
    }
}
