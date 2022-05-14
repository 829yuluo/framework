package indi.yuluo.springboot001springmvc.controller.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @FileName: School.java
 * @createTime: 2022/5/7 17:42
 * @Description:
 */

@Component  // 将此类交给spring容器进行管理
@ConfigurationProperties(prefix = "abc")  // 读取properties配置文件
public class School {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private String name;

    private String website;


}
