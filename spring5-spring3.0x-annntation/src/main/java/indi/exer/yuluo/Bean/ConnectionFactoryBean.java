package indi.exer.yuluo.Bean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: yuluo
 * @createTime: 2021/12/6 20:17
 * @Description:
 */

public class ConnectionFactoryBean implements FactoryBean<Connection> {

    public Connection getObject() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "w082916x");

        return connection;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
