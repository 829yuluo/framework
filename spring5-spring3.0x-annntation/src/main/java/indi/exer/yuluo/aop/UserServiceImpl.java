package indi.exer.yuluo.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @createTime: 2021/12/10 22:04
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void register() {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public void login() {
        System.out.println("UserServiceImpl.login");
    }
}
