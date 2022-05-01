package indi.exer.yuluo.injection;

import org.springframework.stereotype.Repository;

/**
 * @author: yuluo
 * @createTime: 2021/12/4 11:22
 * @Description: @Repository注解
 */

@Repository
public class UserDAOImpl implements UserDAO {
    public void save() {
        System.out.println("UserDAOImpl.save");
    }
}
