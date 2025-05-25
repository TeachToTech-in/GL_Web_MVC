package com.rahul.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonConfig {
//	@Pointcut("execution(* com.rahul.service.*.*(..))")
//	public void serviceConfig() {
//	}
	@Pointcut("bean(*Service*)")
	public void serviceBeanConfig() {
	}
	@Pointcut("@annotation(com.rahul.aop.TrackTime)")
	public void repositoryAnnotationConfig() {
	}
	
	
	
}
