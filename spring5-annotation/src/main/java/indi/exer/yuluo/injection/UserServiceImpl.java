package indi.exer.yuluo.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @createTime: 2021/12/4 11:37
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Autowired
    @Qualifier("userDAOImpl")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register() {
        System.out.println("UserServiceImpl.register");
    }
}
