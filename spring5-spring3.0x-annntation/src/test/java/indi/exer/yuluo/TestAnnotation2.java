package indi.exer.yuluo;

import indi.exer.yuluo.YAML.Account;
import indi.exer.yuluo.YAML.YmlAutoConfiguration;
import indi.exer.yuluo.mybatis.MyBatisAutoConfiguration;
import indi.exer.yuluo.mybatis.User;
import indi.exer.yuluo.mybatis.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author: yuluo
 * @createTime: 2021/12/11 11:47
 * @Description:
 */

public class TestAnnotation2 {

    /**
     * 用于测试：纯注解开发mybatis
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyBatisAutoConfiguration.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        User user = new User();
        user.setName("test");
        user.setPassword("456");

        userDAO.save(user);
    }

    /**
     * 用于测试：yaml
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(YmlAutoConfiguration.class);
        Account account = (Account) ctx.getBean("account");

        System.out.println("account.getName() = " + account.getName());
        System.out.println("account.getPassword() = " + account.getPassword());

        List<String> list = account.getList();
        for (String s : list) {
            System.out.println("s = " + s);
        }

    }

}
