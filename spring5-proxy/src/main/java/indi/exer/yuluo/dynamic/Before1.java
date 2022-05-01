package indi.exer.yuluo.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: yuluo
 * @createTime: 2021/11/20 15:43
 * @Description:
 */

public class Before1 implements MethodBeforeAdvice {

    /**
     * 作用：需要把执行在原始方法之前运行的额外功能，书写在before方法中
     *
     * Method：额外功能所增加的那个原始方法
     *      login方法
     *
     *      register方法
     *
     * Object[]: 额外功能所增加给的那个原始方法的参数：String name, Sting passwd
     *                                         User user
     *
     * Object: 额外功能所增加给的那个原始对象 Method对应的对象 UserServiceImpl
     *                                                OrderServiceImpl
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("-----new Method before advice log-----");
    }
}
