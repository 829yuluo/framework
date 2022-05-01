package indi.exer.yuluo.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 静态工厂创建复杂对象
 *  和实例工厂最大的区别是避免创建对象
 *
 *  主要体现在配置文件的差异
 *
 */

public class StaticConnetionFactory {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSl=false", "root", "w082916x");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;

    }
}
