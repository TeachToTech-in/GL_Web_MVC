package com.rahul.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("com.rahul.aop.CommonConfig.commonController()")
	public void beforeTargetMethodController(JoinPoint joinpoint) {
		// Logic / Advice
		logger.info("Before Advice Bean Service Fexecuted - {}", joinpoint);
	}

	@Before("com.rahul.aop.CommonConfig.commonService()")
	public void beforeTargetMethod(JoinPoint joinpoint) {
		// Logic / Advice
		logger.info("Before Advice executed - {}", joinpoint);
	}

	@After("com.rahul.aop.CommonConfig.commonService()")
	public void afterTargetMethod(JoinPoint joinpoint) {
		// Logic / Advice
		logger.info("After Advice executed - {}", joinpoint);
	}

	@AfterThrowing(pointcut = "com.rahul.aop.CommonConfig.commonService()", throwing = "exception")

	public void afterThrowingTargetMethod(JoinPoint joinpoint, Exception exception) {
		// Logic / Advice
		logger.info("After Advice executed - {} with following Exception {} ", joinpoint, exception);

	}

	@Around("com.rahul.aop.CommonConfig.performancePointCut()")
	public Object aroundTargetMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTimeMillis = System.currentTimeMillis();// Before The Method Call
		// Execute the method
		Object returnValue = proceedingJoinPoint.proceed();
		// Stop the timer
		// After The Target Method Get Over
		long stopTimeMillis = System.currentTimeMillis();
		long executionDuration = stopTimeMillis - startTimeMillis;
		logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);
		return returnValue;

	}

}
