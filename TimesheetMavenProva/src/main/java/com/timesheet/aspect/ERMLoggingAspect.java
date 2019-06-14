package com.timesheet.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ERMLoggingAspect {

	//setup logger
	private Logger myLogger= Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.timesheet.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the same for service and dao packages
	@Pointcut("execution(* com.timesheet.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.timesheet.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method I am calling
		String theMethod= theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @Before calling method: "+ theMethod);
		
		//display the argument to the method
		
		//get the arguments
		Object[]args=theJoinPoint.getArgs();
		
		//loop through and display the arguments
		for(Object tempArgs : args) {
			myLogger.info("======> argument: "+tempArgs);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(
					pointcut="forAppFlow()",
					returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display method I am returning from
		String theMethod= theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @AfterReturning: from method: "+ theMethod);
		
		//display data returned
		myLogger.info("=====> result: "+theResult);
	}
}