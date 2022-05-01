package indi.exer.yuluo;

import indi.exer.yuluo.dao.UserDAO;
import indi.exer.yuluo.entity.User;
import indi.exer.yuluo.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: yuluo
 * @createTime: 2021/11/27 17:25
 * @Description:
 */


public class TestMybatisSpring {

    /**
     * 用于测试：Spring与Mybatis的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        User user = new User();
        user.setName("huakai");
        user.setPassword("x082916w");

        userDAO .save(user);

    }

    /**
     * 用于测试：spring控制事务
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setName("123");
        user.setPassword("456");

        userService.register(user);
    }

}
