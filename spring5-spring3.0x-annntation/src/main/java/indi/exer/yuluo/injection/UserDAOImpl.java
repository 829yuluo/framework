package indi.exer.yuluo.injection;

import org.springframework.stereotype.Repository;

/**
 * @author: yuluo
 * @createTime: 2021/12/8 20:01
 * @Description:
 */

// @Repository是@Component的衍生注解
@Repository
public class UserDAOImpl implements UserDAO {
    public void save() {
        System.out.println("UserDAOImpl.save");
    }
}
