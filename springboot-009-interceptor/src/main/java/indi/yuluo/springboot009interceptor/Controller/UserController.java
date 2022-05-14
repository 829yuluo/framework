package indi.yuluo.springboot009interceptor.Controller;

import indi.yuluo.springboot009interceptor.modle.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yuluo
 * @FileName: UserController.java
 * @createTime: 2022/5/13 21:16
 * @Description:
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login")
    public @ResponseBody Object login(HttpServletRequest request) {

        // 将用户信息存到session中
        User user = new User();
        user.setId(1001);
        user.setUsername("Yuluo");
        request.getSession().setAttribute("user", user);

        return "login SUCCESS";
    }

    /**
     * 需要用户登录之后访问
     */
    @RequestMapping(value = "/center")
    public @ResponseBody Object center() {

        return "See Center Message";
    }

    /**
     * 不登陆也可以访问
     * @return
     */
    @RequestMapping(value = "/out")
    public @ResponseBody Object out() {
        return "Out see anytime";
    }

    /**
     * 如果用户未登录访问了需要登录才能访问的页面，跳转至此页面
     */
    @RequestMapping(value = "/error")
    public @ResponseBody String error() {

        return "error";
    }
}
