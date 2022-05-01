package indi.exer.yuluo.aspect;

import indi.exer.yuluo.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yuluo
 * @createTime: 2021/11/25 16:55
 * @Description:
 */

public class TestAspectProxy {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userServiceImpl = (UserService) ctx.getBean("userService");

        userServiceImpl.login("yuluo", "123456");
        userServiceImpl.register(new User());

    }
}
