package indi.yuluo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: TestController.java
 * @createTime: 2022/4/7 13:05
 * @Description:
 */

@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
