package indi.exer.yuluo.CGlib;

import indi.exer.yuluo.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: yuluo
 * @createTime: 2021/11/24 12:12
 * @Description: 测试类
 */

public class TestCGlib {

    public static void main(String[] args) {
        // 1 创建原始对象
        final UserService userService = new UserService();

        /*
        2 通过CGlib的方式创建动态代理的对象

           Proxy.new ProxyInstance(classloader, interface, invocationHandler)

           Enhancer.setClassLoader();  --> 类加载器
           Enhancer.setSuperClass();  --> 指定父类
           Enhancer.setCallback();  --> MethodInterceptor(cglib) 设定额外功能
          (增强)Enhancer.create() --> 创建代理

         */
        Enhancer enhancer = new Enhancer();

        // 借用类加载器
        enhancer.setClassLoader(TestCGlib.class.getClassLoader());
        // 指定父类
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            // 内部类实现intercept方法
            // 等同于 InvocationHandler --> invoke
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                // 额外功能的添加
                System.out.println("------cglib log-------");

                Object ret = method.invoke(userService, args);

                return ret;
            }
        };

        enhancer.setCallback(interceptor);

        UserService userServiceProxy = (UserService) enhancer.create();

        userServiceProxy.login("yuluo", "123456");
        userServiceProxy.register(new User());
    }

}
