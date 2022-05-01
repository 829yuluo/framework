package indi.exer.yuluo.config;

import indi.exer.yuluo.injection.UserDAO;
import indi.exer.yuluo.injection.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 20:42
 * @Description:
 */

@Configuration
public class AppConfig2 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

}
