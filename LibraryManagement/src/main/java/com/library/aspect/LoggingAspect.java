package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    // Before Advice - Runs before method execution
    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("⏳ [BEFORE] Executing: " + joinPoint.getSignature().getName());
    }
    
    // After Advice - Runs after method execution
    @After("execution(* com.library.service.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        System.out.println("✅ [AFTER] Completed: " + joinPoint.getSignature().getName());
    }
    
    // Around Advice - Runs before and after with timing
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        System.out.println("⏱️ [AROUND] Starting: " + joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        System.out.println("⏱️ [AROUND] " + joinPoint.getSignature().getName() + 
                           " executed in " + executionTime + "ms");
        
        return result;
    }
}
