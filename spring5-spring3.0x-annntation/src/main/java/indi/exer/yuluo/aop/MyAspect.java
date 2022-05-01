package indi.exer.yuluo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 22:06
 * @Description: aop切面开发
 */

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* indi.exer.yuluo.aop..*.*(..))")
    public void pointCut() {}

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 额外功能
        System.out.println("----log -----");
        Object proceed = joinPoint.proceed();


        return proceed;

    }

}
