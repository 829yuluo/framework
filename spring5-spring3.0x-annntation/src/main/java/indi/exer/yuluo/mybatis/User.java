package indi.exer.yuluo.mybatis;

/**
 * @author: yuluo
 * @createTime: 2021/12/11 11:41
 * @Description:
 */

public class User {

    private Integer id;
    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
}
