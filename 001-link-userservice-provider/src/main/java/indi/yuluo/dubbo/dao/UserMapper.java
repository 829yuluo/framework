package indi.yuluo.dubbo.dao;

import indi.yuluo.dubbo.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author: yuluo
 * @FileName: UserMapper.java
 * @createTime: 2022/4/27 13:12
 * @Description:
 */

@Repository
public class UserMapper {

    public User queryUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("yuluo");

        return user;
    }
    


}
