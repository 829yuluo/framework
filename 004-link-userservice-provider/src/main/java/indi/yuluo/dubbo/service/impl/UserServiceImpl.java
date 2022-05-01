package indi.yuluo.dubbo.service.impl;

import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @FileName: UserServiceImpl.java
 * @createTime: 2022/4/28 16:29
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User queryUserById(Integer id) {
        return new User(id, "yuluo");
    }

    @Override
    public Integer queryAllUSerCount() {
        return 100;
    }
}
