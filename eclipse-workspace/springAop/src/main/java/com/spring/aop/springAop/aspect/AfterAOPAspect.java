package com.spring.aop.springAop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAOPAspect { //aspect

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("com.spring.aop.springAop.aspect.CommonJoinPointConfig.dataLayerExecution()") //joinpoint
	public void before(JoinPoint joinpoint) {
		logger.info("Intercepted - {}", joinpoint); //advice
	}
	
}