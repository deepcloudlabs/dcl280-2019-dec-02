package com.example.hr.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
   @Around("execution(* com.example..*.*(..))")
   public Object log(ProceedingJoinPoint pjp) throws Throwable {
	   System.err.println(pjp.getSignature().getName()+ " is running...");
	   return pjp.proceed();
   }
   
}
