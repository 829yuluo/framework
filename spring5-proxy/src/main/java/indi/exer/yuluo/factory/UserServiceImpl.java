package indi.exer.yuluo.factory;

import indi.exer.yuluo.proxy.User;

/**
 * @author: yuluo
 * @createTime: 2021/11/24 21:17
 * @Description:
 */

public class UserServiceImpl implements UserService{

    @Override
    public void login(String name, String passwd) {
        System.out.println("factory UserServiceImpl.login");
    }

    @Override
    public void register(User user) {
        System.out.println("factory UserServiceImpl.register");
    }
}
