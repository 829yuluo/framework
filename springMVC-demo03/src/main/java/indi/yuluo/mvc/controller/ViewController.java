package indi.yuluo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: ViewController.java
 * @createTime: 2022/3/26 19:30
 * @Description:
 */

@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {

        return "success";
    }

}
