package indi.exer.yuluo.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: yuluo
 * @createTime: 2021/11/19 19:03
 * @Description:
 */

public class Before implements MethodBeforeAdvice {

    /**
     * 作用：需要把执行在原始方法之前运行的额外功能，书写在before方法中
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--------method before advice log---------");

    }
}
