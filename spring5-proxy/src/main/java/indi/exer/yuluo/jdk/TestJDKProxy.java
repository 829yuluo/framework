package indi.exer.yuluo.jdk;

import indi.exer.yuluo.proxy.User;
import indi.exer.yuluo.proxy.UserService;
import indi.exer.yuluo.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: yuluo
 * @createTime: 2021/11/23 20:53
 * @Description: JDK动态代理分析
 */

public class TestJDKProxy {

    public static void main(String[] args) throws Exception {
        // 创建原始对象
        final UserService userService = new UserServiceImpl();

        // jdk创建动态代理
        /*
         三个参数：
            1 classloader

            2 interfaces
                原始对象 所实现的接口

                interface：
                    userService.getClass.getInterfaces();

                类加载器的作用：
                    User --> user
                    User类的Class对象 --> new User() --> user
                    1 通过类加载器把对应的字节码文件加入到JVM
                    2 通过类加载器创建类的Class对象，进而创建这个类的对象

                 如何获得类加载器
                    每一个类的.class文件自动分配与之对应的ClassLoader

            3 invocationHandler
                 中有一个invoke方法
                 作用是 用于书写额外功能，额外功能运行在原始方法执行前，执行后，前后 抛出异常
                 object 原始方法的返回值
                 参数 Proxy 忽略掉 代表的是代理对象
                     Method 额外功能，所增加给那个原始方法
                     Object[] 原始方法的参数
                     Object invoke(Object proxy, Method method, Object[] args) {

                        Object ret = method.invoke(userService, args);

                        return ret;

                     }
         */

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 额外功能的添加
                System.out.println("--------proxy log---------");

                // 原始方法运行
                Object ret = (Object) method.invoke(userService, args);

                return ret;
            }
        };

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.
                getClassLoader(), userService.getClass().getInterfaces(), handler);

        userServiceProxy.login("suns", "123456");
        userServiceProxy.register(new User());

    }
}
