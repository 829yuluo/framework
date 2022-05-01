package indi.exer.yuluo.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @createTime: 2021/12/4 12:08
 * @Description:
 */

// 替换spring配置文件中的<bean 标签来创建相应的对象
@Component
// 代替spring配置文件中的<context location的相关内容
@PropertySource("classpath:/init.properties")
public class Category {

    /*从properties配置文件中读取到相应的值。通过@Value注解进行属性注入*/
    @Value("${id}")
    private Integer id;
    @Value("$name")
    private String name;
    private String password;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
