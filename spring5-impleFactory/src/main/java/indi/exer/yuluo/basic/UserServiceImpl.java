package indi.exer.yuluo.basic;

public class UserServiceImpl implements UserService {

    //存在耦合问题 利用工厂设计模式解决耦合问题
    //UserDAO userDAO = new UserDAOImpl();

    //利用自己编写的工厂方法获得对象
    UserDAO userDAO1 = (UserDAO) BeanFactory.getBean("userDAO");

    //在引入了spring的工厂之后，通过spring的方式完成set注入

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {

        userDAO.save(user);
    }

    @Override
    public void login(String name, String password) {

        userDAO.queryUserByUserAndPassword(name, password);
    }

}
