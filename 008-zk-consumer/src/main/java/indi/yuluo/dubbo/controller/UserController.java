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
 * @createTime: 2022/4/28 21:39
 * @Description:
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String user(Model model, Integer id, String name) {

        System.out.println(name);

        User user = userService.queryUserById(id, name);
        model.addAttribute("user", user);

        return "userDetail";
    }

}
