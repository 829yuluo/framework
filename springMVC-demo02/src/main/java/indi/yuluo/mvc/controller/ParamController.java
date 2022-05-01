package indi.yuluo.mvc.controller;

import indi.yuluo.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: yuluo
 * @FileName: ParamController.java
 * @createTime: 2022/3/24 12:54
 * @Description:
 */

@Controller
public class ParamController {

    /**
     * 形参位置的request表示当前请求
     * @param request
     * @return
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + " " + password);

        return "success";
    }


    /**
     * springMVC的传值方式，通过方法的形参传递参数
     * @RequestParam注解的作用处理前端传值的变量名和后端形参名不对应的问题
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam("user_name") String username,
            String password,
            String hobby,
            @RequestHeader(value="Host", required=true, defaultValue="haha") String host,
            @CookieValue("HSESSIONID") String JSESSIONID) {

        System.out.println("username: " + username + " password: " + password + " 爱好：" + hobby);
        System.out.println("host: " + host);
        System.out.println("cookie: " + JSESSIONID);


        return "success";
    }

    @RequestMapping("/testBean")
    public String testPOJO(User user) {

        System.out.println("user = " + user);

        return "success";

    }


}
