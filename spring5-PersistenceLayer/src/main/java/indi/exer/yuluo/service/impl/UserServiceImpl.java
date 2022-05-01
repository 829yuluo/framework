package indi.exer.yuluo.service.impl;

import indi.exer.yuluo.dao.UserDAO;
import indi.exer.yuluo.entity.User;
import indi.exer.yuluo.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yuluo
 * @createTime: 2021/11/28 13:23
 * @Description:
 */

/* 切入点的方式 通过注解 */
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 依赖UserDAO，所以把userDAO作为他的成员变量引入，通过spring的控制文件进行依赖注入
     */
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.save(user);
    }
}
