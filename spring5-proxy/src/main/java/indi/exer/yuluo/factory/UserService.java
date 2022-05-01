package indi.exer.yuluo.factory;

import indi.exer.yuluo.proxy.User;

/**
 * @author: yuluo
 * @createTime: 2021/11/24 21:14
 * @Description:
 */

public interface UserService {

    public void login(String name, String passwd);
    public void register(User user);

}
