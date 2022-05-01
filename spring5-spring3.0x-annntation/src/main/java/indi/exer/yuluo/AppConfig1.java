package indi.exer.yuluo;

import indi.exer.yuluo.Bean.Customer;
import indi.exer.yuluo.injection.UserDAO;
import indi.exer.yuluo.injection.UserDAOImpl;
import indi.exer.yuluo.injection.UserService;
import indi.exer.yuluo.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: yuluo
 * @createTime: 2021/12/8 20:05
 * @Description:
 */

// 读取properties属性配置文件 来解决字符串的耦合
@PropertySource("classpath:customer.properties")
@Configuration
// @ComponentScan注解代替applicationContext.xml配置文件中的
// <context:component-scan base-packages="indi.exer.yuluo"/>
@ComponentScan(basePackages = "indi.exer.yuluo")
public class AppConfig1 {

    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    /*@Bean
    // 通过这种方式就完成了对UserService中的UserDAO类型变量的注入
    // 替代xml中的注入方法
    public UserService userService(UserDAO userDAO) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }*/

    // 简化的注入方法
    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO());

        return userService;
    }

    @Bean
    // 演示对于jdk类型成员变量的注入
    // 存在字符串耦合
    public Customer customer() {
        Customer customer  = new Customer();
        customer.setId(id);
        customer.setName(name);

        return customer;
    }

}
