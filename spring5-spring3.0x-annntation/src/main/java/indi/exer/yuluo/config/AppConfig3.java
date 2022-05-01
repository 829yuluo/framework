package indi.exer.yuluo.config;

import indi.exer.yuluo.injection.UserDAO;
import indi.exer.yuluo.injection.UserService;
import indi.exer.yuluo.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 21:11
 * @Description:
 */

@Configuration
@ComponentScan(basePackages = "indi.exer.yuluo.injection")
public class AppConfig3 {

    // 进行成员变量注入
    @Autowired
    private UserDAO userDAO;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }

}
