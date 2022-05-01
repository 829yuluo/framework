package indi.yuluo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: yuluo
 * @FileName: RequestMappingController.java
 * @createTime: 2022/3/23 19:02
 * @Description: 测试RequestMapping注解
 */

@Controller
@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(
            value = {"/target", "test"},
            // 根据请求方法匹配映射路径
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String index() {
        return "target";
    }

    @GetMapping("/testGetMapping") // 要求请求方式为GET请求方式
    public String testGetMapping() {
        return "target";
    }

    // Ant风格的路径测试 ？ * ** 使用两个*时只能/**/xxx这样使用
    @RequestMapping("/a?a/testAnt")
    public String testAnt() {
        return "target";
    }

    // 占位符 {}
    @RequestMapping("/testPath/{id}")
    public String testPath(@PathVariable("id") Integer id) {
        System.out.println("id: " + id);
        return "target";
    }

}
