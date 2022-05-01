package indi.exer.yuluo.injection;

/**
 * @author: yuluo
 * @createTime: 2021/12/8 20:02
 * @Description:
 */

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register() {
        userDAO.save();
    }
}
