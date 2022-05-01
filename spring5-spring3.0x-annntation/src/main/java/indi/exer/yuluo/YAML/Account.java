package indi.exer.yuluo.YAML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yuluo
 * @createTime: 2021/12/11 17:23
 * @Description:
 */

@Component
public class Account {

    // @Value("${name}")
    @Value("${account.name}")
    private String name;
    // @Value("${password}")
    @Value("${account.password}")
    private String password;

    // @Value("${list}")
    @Value("#{'${list}'.split(',')}")
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
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
