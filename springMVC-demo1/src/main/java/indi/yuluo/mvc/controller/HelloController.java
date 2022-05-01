package indi.yuluo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @createTime: 2022/3/21 16:38
 * @File: HelloController.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

// 创建一个控制器 标记为控制层组件
@Controller
public class HelloController {

    // 请求路径 “/”WEB-INF/templates/index.html
    @RequestMapping("/")  // “请求映射” 处理请求和控制器方法创建映射关系
    public String index() {
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

}
