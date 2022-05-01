package indi.yuluo.dubbo.service.impl;

import indi.yuluo.dubbo.dao.UserMapper;
import indi.yuluo.dubbo.model.User;
import indi.yuluo.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @FileName: UserServiceImpl.java
 * @createTime: 2022/4/27 13:04
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper = new UserMapper();

    @Override
    public User queryUserById(Integer id) {

        System.out.println("userService id： " + id);

        return userMapper.queryUserById(id);
    }
}
