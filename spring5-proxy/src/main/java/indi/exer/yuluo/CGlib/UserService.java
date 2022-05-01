package indi.exer.yuluo.CGlib;

import indi.exer.yuluo.proxy.User;

/**
 * @author: yuluo
 * @createTime: 2021/11/24 12:10
 * @Description: CGlib动态代理  继承父类
 */

public class UserService {

    public void login(String name, String passwd) {
        System.out.println(" test UserService.login");
    }

    public void register(User user) {
        System.out.println("test UserService.register");
    }

}
