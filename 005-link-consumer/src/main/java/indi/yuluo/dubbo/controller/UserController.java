package indi.yuluo.dubbo.controller;

import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: UserController.java
 * @createTime: 2022/4/28 16:45
 * @Description:
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String User(Model model, Integer id) {

        User user = userService.queryUserById(id);
        Integer integer = userService.queryAllUSerCount();

        model.addAttribute("user", user);
        model.addAttribute("count", integer);

        return "UserDetail";

    }

}
