package indi.exer.yuluo.entity;

import java.io.Serializable;

/**
 * @author: yuluo
 * @createTime: 2021/11/27 17:19
 * @Description:
 */

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
}
