package indi.yuluo.controller;

import indi.yuluo.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: yuluo
 * @FileName: HelloController.java
 * @createTime: 2022/4/3 19:26
 * @Description:
 */

@Controller
public class HelloController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {

        System.out.println("requestBody:" + requestBody);

        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        // 当前的requestEntity表示整个请求头的信息
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());

        return "success";
    }

    /**
     * 通过servlet api的response对象来响应数据到浏览器
     * @param response
     * @throws IOException
     */
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("Hello Response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody  //标注控制器方法,返回值为响应到浏览器的数据
    public String testResponseBody() {
        return "success";
    }

    @RequestMapping("/testResponseBodyUser")
    @ResponseBody
    public User testResponseBodyUser() {

        User user = new User();
        user.setAge(12);
        user.setName("wife");
        user.setPassword("12344");
        user.setId(1);

        return user;
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAjax(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "hello axios";
    }

}
