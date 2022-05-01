package indi.yuluo.web.controller;

import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;
import indi.yuluo.dubbo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: UserController.java
 * @createTime: 2022/4/27 13:07
 * @Description:
 */

@Controller
public class UserController {

    UserService userService = new UserServiceImpl();

    @RequestMapping(value = "/user")
    public String queryUserById(Model model, Integer id) {

        System.out.println("user id: " + id);

        User user = userService.queryUserById(id);
        model.addAttribute("user", user);

        return "UserDetail";
    }

}
