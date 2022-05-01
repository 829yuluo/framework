package indi.exer.yuluo.aspect;

import indi.exer.yuluo.proxy.User;

public interface UserService {

    void login(String name, String password);

    void register(User user);

}
