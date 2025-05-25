package com.rahul.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonConfig {

	@Pointcut("execution(* com.rahul.service.*.*(..))")
	public void commonService() {}
	
	@Pointcut("bean(*Service*)")
	public void commonController() {}
	@Pointcut("@annotation(com.rahul.aop.annotation.TrackTime)")
	public void performancePointCut() {}
}
