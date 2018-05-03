package com.vany.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vany.handler.GlobalExceptionHandler;

/**
 * 该切面是用于过滤用户发布的内容
 * @author van元
 *
 */
@Aspect
@Component
public class PublishAspect {
	
	//任何方法以Publish结尾的都拦截
	@Pointcut("execution(* *Publish(..))")
	public void pub() {}
	@Autowired
	GlobalExceptionHandler globalExceptionHandler;
	
	@Around("pub()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		for(Object obj : args) {
			System.out.println(obj.toString());
		}
		args[0] ="你传入的参数已经被过滤啦>>"+args[0];
		try {
		} catch (Exception e) {	//如果发现全局异常，就处理
			return globalExceptionHandler.handle(e);
		}
		return joinPoint.proceed(args);
	}

}
