package indi.exer.yuluo;

import indi.exer.yuluo.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yuluo
 * @createTime: 2021/11/18 19:25
 * @Description:
 */

public class text {

    /**
     * 用于测试：
     */
    @Test
    public void text1() {
        UserService userService= new UserServiceProxy();
        userService.login("yuluo", "123456");

        System.out.println("------------");

        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 用于测试：Spring动态代理开发测试
     */
    @Test
    public void test2() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**注意：
        1. Spring的工厂通过原始对象的id值获得的是代理对象
        2. 获得代理对象后，可以通过  声明接口类型，  进行对象的存储*/
        UserService userService = (UserService) ctx.getBean("userService");

        // USerService时代理对象
        userService.login("yuluo", "w082916x");
        userService.register(new User());
    }

    /**
     * 用于测试：OrderService动态代理
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");

        orderService.showOrder();
    }

}
