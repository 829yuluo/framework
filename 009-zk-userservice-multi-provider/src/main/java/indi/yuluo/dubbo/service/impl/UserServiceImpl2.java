package indi.yuluo.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;

/**
 * @author: yuluo
 * @FileName: UserServiceImpl2.java
 * @createTime: 2022/4/30 9:27
 * @Description:
 */

@Service
public class UserServiceImpl2 implements UserService {
    public User queryUserById(Integer id, String username) {

        User user = new User();
        user.setId(id);
        user.setUsername(username + "-2");

        return user;
    }
}
