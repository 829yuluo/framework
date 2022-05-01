package indi.yuluo.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;

/**
 * @author: yuluo
 * @FileName: UserServiceImpl.java
 * @createTime: 2022/4/30 9:18
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {
    public User queryUserById(Integer id, String username) {

        User user = new User();
        user.setId(id);
        user.setUsername(username + "-1");

        return user;
    }
}
