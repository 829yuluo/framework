package indi.yuluo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: HelloController.java
 * @createTime: 2022/4/6 12:21
 * @Description:
 */

@Controller
public class HelloController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {



        return "success";
    }

}
