package indi.exer.yuluo.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 21:54
 * @Description:
 *
 * aop的开发步骤:
 *   1.原始对象
 *   @Service
 *   public void UserSeriviceImpl implements UserServices {
 *
 *   }
 *   2.创建切面类 （额外功能 切入点 组装切面）
 *   @Aspect
 *   @Component
 *   public void MyAspect {
 *      @Around("execution(* login(..))")
 *      public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
 *
 *          System.out.println("----aspect log----");
 *
 *          Object ret = joinPoint.proceed();
 *
 *          return ret;
 *      }
 *   }
 *   3.spring的配置文件中
 *      <aop:aspectj-autoproxy/>
 *      spring提供了一个注解来替换这个标签
 *      @EnableAspectjAutoProxy
 *   4.
 *
 */

@Configuration
@ComponentScan(basePackages = "indi.exer.yuluo.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
