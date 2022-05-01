package indi.exer.yuluo;

import indi.exer.yuluo.Bean.Customer;
import indi.exer.yuluo.Bean.User;
import indi.exer.yuluo.config.AppConfig3;
import indi.exer.yuluo.config.AppConfig4;
import indi.exer.yuluo.injection.UserDAO;
import indi.exer.yuluo.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

/**
 * @author: yuluo
 * @createTime: 2021/12/5 15:11
 * @Description:
 */

public class TestSpring3Annotation {

    /**
     * 用于测试spring配置Bean
     */
    @Test
    public void test1() {
        // 参数名可以写配置Bean的反射文件也可以写配置Bean所在的包名
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("indi.exer.yuluo");
        /*ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);*/

    }

    /**
     * 用于测试：@Bean标签
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        /*User user = (User) ctx.getBean("user");
        System.out.println("user = " + user);*/

        Connection conn = (Connection) ctx.getBean("connection");
        System.out.println("conn = " + conn);

        /*Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);*/
    }

    /**
     * 用于测试：对象的创建次数
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("indi.exer.yuluo");
        User user = (User) ctx.getBean("user");
        User user1 = (User) ctx.getBean("user");

        System.out.println("user = " + user);
        System.out.println("user1 = " + user1);
    }

    /**
     * 用于测试：@Bean注解中的注入
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        UserService userService = (UserService) ctx.getBean("userService");

        userService.register();
    }

    /**
     * 用于测试：@Bean对jdk类型成员变量的注入
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        Customer customer = (Customer) ctx.getBean("customer");

        System.out.println("customer = " + customer);
        System.out.println(customer.getId());
        System.out.println(customer.getName());
    }

    /**
     * 用于测试：@ComponentScan注解
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);

        // 获得的是spring工厂所创建的那些id值
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 用于测试：多配置bean的整合
     *
     * 基于basePackage及逆行配置bean的整合
     *
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("indi.exer.yuluo.config");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");

        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);
    }

    /**
     * 用于测试：多配置bean的整合
     *
     * 基于basePackage及逆行配置bean的整合
     *
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(indi.exer.yuluo.config.AppConfig1.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");

        System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);
    }

    /**
     * 用于测试：跨配置文件进行注入
     *
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(indi.exer.yuluo.config.AppConfig1.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        UserService userService = (UserService) ctx.getBean("userService");

        /*System.out.println("userService = " + userService);
        System.out.println("userDAO = " + userDAO);*/
        userService.register();
    }

    /**
     * 用于测试：@Component与配置Bean的整合
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
        UserService userService = (UserService) ctx.getBean("userService");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAOImpl");

        System.out.println("userDAOImpl = " + userDAO);
        System.out.println("UserService = " + userService);
    }

    /**
     * 用于测试：配置Bean和配置文件的整合
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
        UserService userService = (UserService) ctx.getBean("userService");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");

        System.out.println("userDAOImpl = " + userDAO);
        System.out.println("UserService = " + userService);
    }

}


