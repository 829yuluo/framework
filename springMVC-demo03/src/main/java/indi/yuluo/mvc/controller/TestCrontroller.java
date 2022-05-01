package indi.yuluo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: TestCrontroller.java
 * @createTime: 2022/3/25 22:14
 * @Description: 专门控制页面跳转的控制器
 */

@Controller
public class TestCrontroller {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/test_view")
    public String test_view() {
        return "test_view";
    }

    @RequestMapping("/test_rest")
    public String test_rest() {return "test_rest";}

}
