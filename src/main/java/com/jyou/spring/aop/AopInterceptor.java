package com.jyou.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopInterceptor {
	@Pointcut("execution(public * com.jyou.spring.service.impl.BasicService.getMessage(..))")
	private void anyMethod() {
	}
	
	@Before("anyMethod()&&args(name)")
	public void beforeAdvice(String name) {
		// String name
		System.out.println("before:" + name);
	}
	
	/*
	 */
	@AfterReturning(pointcut = "anyMethod()", returning = "revalue")
	public void returnAdvice(String revalue) {
		System.out.println("return:" + revalue);
	}

	@AfterThrowing(pointcut = "anyMethod()", throwing = "e")
	public void exceptionAdvice(Exception e) {
		System.out.println("exception:" + e.toString());
	}

	@After("anyMethod()")
	public void releaseAction() {
		System.out.println("after:");
	}

	@Around("anyMethod()")
	public Object bacicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start:");
		Object result = pjp.proceed();
		System.out.println("around end:");
		return result;
	}

}