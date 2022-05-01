package indi.yuluo.dubbo.controller;

import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yuluo
 * @FileName: USerController.java
 * @createTime: 2022/4/30 9:41
 * @Description:
 */

@Controller
public class USerController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService userService2;

    @RequestMapping(value = "/user")
    public String userDetail(Model model, Integer id, String name) {
        User user = userService.queryUserById(id, name);

        User user1 = userService2.queryUserById(id, name);

        model.addAttribute("user", user);
        model.addAttribute("user1", user1);

        return "userDetail";
    }

}
