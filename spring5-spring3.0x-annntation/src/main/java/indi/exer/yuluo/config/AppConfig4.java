package indi.exer.yuluo.config;

import indi.exer.yuluo.injection.UserDAO;
import indi.exer.yuluo.injection.UserService;
import indi.exer.yuluo.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 21:27
 * @Description:
 *
 * 配置Bean和配置文件的整合
 *
 */

@Configuration
@ImportResource("applicationContext.xml")
public class AppConfig4 {

    /**
     * IDEA联想不到在配置文件中配置的UserDAO的内容、
     * 所以会报错，不影响
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
