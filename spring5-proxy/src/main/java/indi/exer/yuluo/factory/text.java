package indi.exer.yuluo.factory;

import indi.exer.yuluo.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yuluo
 * @createTime: 2021/11/24 21:30
 * @Description:
 */

public class text {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.login("yuluo", "123456");
        userService.register(new User());
    }

}
