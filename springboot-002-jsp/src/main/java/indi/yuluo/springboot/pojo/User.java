package indi.yuluo.springboot.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: yuluo
 * @FileName: user.java
 * @createTime: 2022/5/7 18:30
 * @Description:
 */

@Component
public class User implements Serializable {

    private int id;

    private String name;

    public User() {
    }

    @Override
    public String toString() {
        return "用户{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
