package indi.yuluo.springboot001springmvc.controller;

import indi.yuluo.springboot001springmvc.controller.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: yuluo
 * @FileName: IndexController.java
 * @createTime: 2022/5/5 21:03
 * @Description:
 */

@Controller
public class IndexController {

    @Autowired
    private School school;

    @ResponseBody
    @RequestMapping(value = "/springboot/say")
    public String index() {
        return "Hello! springboot!";
    }

    @RequestMapping(value = "/mapvalue")
    public @ResponseBody Map<String, String> mapValue() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Spring Boot Project!");

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/springboot/school")
    public String say() {


        return "abc.name=" + school.getName() + "----" + "abc.website=" + school.getWebsite();
    }
}
