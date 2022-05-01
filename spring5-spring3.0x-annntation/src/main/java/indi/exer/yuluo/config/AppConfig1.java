package indi.exer.yuluo.config;

import indi.exer.yuluo.injection.UserDAO;
import indi.exer.yuluo.injection.UserDAOImpl;
import indi.exer.yuluo.injection.UserService;
import indi.exer.yuluo.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 20:40
 * @Description:
 */

@Configuration
// 通过import注解来引入第二个配置bean，达到对配置Bean的整合
@Import(AppConfig2.class)

// 在注册工厂的时候指定多个配置bean
public class AppConfig1 {

    /**
     * 跨配置bean进行成员变量的依赖注入
     * 依赖注入思想
     */
    @Autowired
    private UserDAO userDAO;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }

}
