package indi.exer.yuluo.aspect;

/**
 * @author: yuluo
 * @createTime: 2021/11/25 16:27
 * @Description: 切面类
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/*
    1 额外功能
        public void invoke(MethodInvocation invocation) {

            Object ret = invocation.proceed();

            return ret;

        }
    2 切入点 配置
        <aop:config
            <aop:pointcut id="……" expression="execution(* login(..))"/>
 */

@Aspect
public class MyAspect {

    /**
     * 提取切入点表达式
     */
    @Pointcut("execution(* login(..))")
    public void myPointcut(){}

    /* 额外功能的加入点 */
    /*
    切入点表达式的复用
     */
    @Around(value="myPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("-----aspect log-----");
        Object ret = joinPoint.proceed();

        return ret;
    }

    /*@Around("execution(* login(..))")*/
    @Around(value="myPointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {

        /* 日志 */
        System.out.println("-----aspect tx-----");
        Object ret = joinPoint.proceed();

        return ret;
    }

}
