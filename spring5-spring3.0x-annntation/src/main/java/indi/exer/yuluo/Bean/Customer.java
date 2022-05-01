package indi.exer.yuluo.Bean;

import java.io.Serializable;

/**
 * @author: yuluo
 * @createTime: 2021/12/8 20:29
 * @Description:
 */

public class Customer implements Serializable {

    private Integer id;
    private String name;

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
