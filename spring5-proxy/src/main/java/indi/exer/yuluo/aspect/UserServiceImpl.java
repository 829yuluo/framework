package indi.exer.yuluo.aspect;

import indi.exer.yuluo.proxy.User;

/**
 * @author: yuluo
 * @createTime: 2021/11/25 16:12
 * @Description:
 */

public class UserServiceImpl implements UserService {

    @Override
    public void login(String name, String passwd) {
        System.out.println("UserService.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserService.register");
    }

}
