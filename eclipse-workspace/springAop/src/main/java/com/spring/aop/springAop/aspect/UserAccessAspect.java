package com.spring.aop.springAop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect { //aspect

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(value = "com.spring.aop.springAop.aspect.CommonJoinPointConfig.dataLayerExecution()", returning = "result") //joinpoint
	public void after(JoinPoint joinpoint, Object result) {
		logger.info("{} returned with value {}", joinpoint, result); //advice
	}
	
	@AfterThrowing(value = "com.spring.aop.springAop.aspect.CommonJoinPointConfig.dataLayerExecution()", throwing = "exception")
	public void afterError(JoinPoint joinPoint, Object exception) {
		logger.info("{} returned error {}", joinPoint, exception);
	}
	
}