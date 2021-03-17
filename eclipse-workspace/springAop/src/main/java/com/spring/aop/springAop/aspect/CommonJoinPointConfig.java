package com.spring.aop.springAop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	@Pointcut("execution(* com.spring.aop.springAop.business.*.*(..))")
	public void dataLayerExecution() {}
	
	@Pointcut("@annotation(com.spring.aop.springAop.aspect.TrackTime)")
	public void TrackTimeAnnotation() {}
}
