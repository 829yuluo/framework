package indi.exer.yuluo.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: yuluo
 * @createTime: 2021/12/3 16:24
 * @Description: 使用注解开发
 *
 * 创建对象的注解 代替配置文件的中的bean配置
 *
 */

// 指定id名在注解之后的括号里面添加一个
@Component("u")
public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
