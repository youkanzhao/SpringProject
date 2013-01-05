package com.jyou.spring.gemfire;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.gemstone.gemfire.cache.Region;

@Aspect
public class TestGemFireInterceptor {
	
	@Resource(name = "myRegion")
	private Region<Object,Object> region;
	
	@Pointcut("execution(public * com.jyou.spring.gemfire.HelloWorld.greetWorld(..))")
	private void anyMethod() {
	}
	
	
	private Object createCacheKey(ProceedingJoinPoint pjp){
		Object[] args = pjp.getArgs();
		String key = "";
		for(Object obj : args){
			key += obj.toString();
		}
		return key;
	}
	
	
	@Around("anyMethod() && @annotation(ta)")
	public Object bacicProfiling(ProceedingJoinPoint pjp, TestAnnotation ta) throws Throwable {
		System.out.println("around start:");
		Object result;
		Object key = createCacheKey(pjp);
		result = region.get(key);
		if(result == null){
			result = pjp.proceed();
			region.put(key, result);
		}
		System.out.println("around end:");
		return result;
	}

}