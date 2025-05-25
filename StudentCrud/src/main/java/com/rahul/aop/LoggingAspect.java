package com.rahul.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

	// @Before("com.rahul.aop.CommonConfig.serviceConfig()")
	@Before("com.rahul.aop.CommonConfig.serviceBeanConfig()")
	public void BeforMethodCall(JoinPoint joinpoint) {
		logger.info("Before Method call -- Logger Invoked {}", joinpoint);
	}


	@Around("com.rahul.aop.CommonConfig.repositoryAnnotationConfig()")
	// ProceedingJoinPoint : used to Proceed the method
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	//Start a timer
	long startTimeMillis = System.currentTimeMillis();
	//Execute the method
	Object returnValue = proceedingJoinPoint.proceed();
	//Stop the timer
	long stopTimeMillis = System.currentTimeMillis();
	long executionDuration = stopTimeMillis - startTimeMillis;
	logger.info("Around Aspect - {} Method executed in {} ms"
	,proceedingJoinPoint, executionDuration);
	return returnValue;
	}

}
