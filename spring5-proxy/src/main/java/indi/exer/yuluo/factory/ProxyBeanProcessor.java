package indi.exer.yuluo.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: yuluo
 * @createTime: 2021/11/24 21:20
 * @Description:
 */

public class ProxyBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    /*
        Proxy.newProxyInstance();

     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object bean, Method method, Object[] args) throws Throwable {

                System.out.println("-------proxyBeanFactoryProcessor log------");
                Object ret = method.invoke(bean, args);

                return ret;
            }
        };

        return Proxy.newProxyInstance(ProxyBeanProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), handler);


    }
}
