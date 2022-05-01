package indi.yuluo.mybatisplus.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import indi.yuluo.mybatisplus.mapper.UserMapper;
import indi.yuluo.mybatisplus.pojo.User;
import indi.yuluo.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @createTime: 2022/3/16 18:02
 * @File: UserServieImpl.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@Service
public class UserServieImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
