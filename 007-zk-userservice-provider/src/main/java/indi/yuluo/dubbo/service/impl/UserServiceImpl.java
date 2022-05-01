package indi.yuluo.dubbo.service.impl;

import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @FileName: UserServiceImpl.java
 * @createTime: 2022/4/28 21:28
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User queryUserById(Integer id, String name) {

        return new User(id, name);
    }
}
