package indi.exer.yuluo.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author: yuluo
 * @createTime: 2021/11/20 17:13
 * @Description:
 */

public class Arround implements MethodInterceptor {

    /*
        invoke方法的作用：额外功能书写在invoke
                        额外功能    原始方法之前
                                  原始方法之后
                                  原始方法执行之前后
        确定：原始方法怎么运行

        参数 MethodInvocation（Method） ： 额外功能所增加给的那个原始方法
                        login
                        register

        让原始方法运行
        invocation.proceed() ----> login
                                   register

        返回值：Object 原始方法的返回值

            Date convert(String name)
     */

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("-----额外功能 log-----");
        // 让原始方法运行
        Object ret = invocation.proceed();

        /*System.out.println("额外功能运行在了原始方法之前");
        Object ret = invocation.proceed();
        System.out.println("额外功能运行在了原始方法之后");*/

        /*//原始方法抛出异常之前执行额外功能
        Object ret = null;
        try {
            ret = invocation.proceed();
        } catch (Throwable throwable) {

            System.out.println("------额外功能运行在了原始方法抛出异常之前-----");

            throwable.printStackTrace();
        }*/

        return ret;
    }
}
