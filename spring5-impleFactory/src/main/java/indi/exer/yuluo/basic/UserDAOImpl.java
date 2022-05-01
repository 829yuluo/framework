package indi.exer.yuluo.basic;

public class UserDAOImpl implements UserDAO {

    @Override
    public void save(User user) {

        System.out.println("insert into user = " + user);
    }

    @Override
    public void queryUserByUserAndPassword(String name, String password) {
        System.out.println("query User name = " + name + "   password = " + password);
    }

}
