package indi.yuluo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: yuluo
 * @FileName: UserController.java
 * @createTime: 2022/3/27 16:18
 * @Description:
 */

@Controller
public class UserController {

    /**
     * 使用RESTful风格模拟用户资源的增删改查
     *
     * /users   GET     查询所有用户信息
     * /user/1  GET     根据用户id查询用户信息
     * /user    POST    添加用户信息
     * /user/1  DELETE  删除用户信息
     * /user    PUT     修改用户信息
     */
    @RequestMapping(value="/user", method= RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public String getUserById() {
        System.out.println("根据id来查询用户信息");
        return "success";
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public String insertUser(String username, String password) {
        System.out.println("添加用户信息：" + "username：" + username + " password: " + password);

        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息：" + "username：" + username + " password: " + password);

        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(String username, String password) {
        System.out.println("删除用户信息：" + "username：" + username + " password: " + password);

        return "success";
    }

}
