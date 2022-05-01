package indi.exer.yuluo;

import indi.exer.yuluo.Bean.ConnectionFactoryBean;
import indi.exer.yuluo.Bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: yuluo
 * @createTime: 2021/12/5 15:06
 * @Description: 配置Bean
 *
 * 使用@Configuration注解 来完成 applicationContext.xml配置文件的作用
 *
 * @Configuration: 本质：是@Component注解的衍生注解
 *
 */

@Configuration
public class AppConfig {


    /**
     * 创建的是简单对象
     * 方法名相当与xml配置文件中bean标签的id属性的值
     * 方法体中的代码是由程序按自己书写的
     *
     * 在配置Bean中设置对象的创建次数的方法，通过使用@Scope注解来实现
     *
     */
    @Bean
    // 对象可以创建多次 prototype
    // 对象只创建1次 singleton  默认情况下是singleton
    @Scope("prototype")
    public User user() {
        return new User();
    }

    /**
     * 创建复杂对象
     * Connection SqlSessionFactory 不能直接通过new来创建
     *
     * @Bean 创建复杂对象的注意事项：
     *  和之前讲的一样使用工厂
     *
     * @Bean注解 也可以自己指定id名
     * 在@Bean后面加上（）写上id名即可  @Bean("connection")
     *
     */
    @Bean("connection")
    public Connection conn() {
        // 书写创建对象的代码
        // 这样的写法主要用在遗留系统的整合 自己开发通常不这样写
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "w082916x");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Bean
    public Connection conn1() {

        Connection conn = null;

        try {
            ConnectionFactoryBean factoryBean = new ConnectionFactoryBean();
            conn = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
