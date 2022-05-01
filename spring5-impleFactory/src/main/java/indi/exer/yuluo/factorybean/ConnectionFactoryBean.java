package indi.exer.yuluo.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean implements FactoryBean<Connection> {

    //依赖注入的思想，需要密码和账户名以及驱动名称所以把他们定义为成员变量，通过spring配置文件进行注入
    private String driverClassName;
    private String url;
    private String username;
    private String passwd;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    //用于书写创建复杂对象的方法
    //返回值时如果引入泛型，会根据泛型修改返回值类型为接口类型
    @Override
    public Connection getObject() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Class.forName(driverClassName);
        /*Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "w082916x");*/
        Connection connection = DriverManager.getConnection(url, username, passwd);


        return connection;
    }

    @Override
    public Class<?> getObjectType() {

        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
