package indi.yuluo.dubbo.service;

import indi.yuluo.dubbo.model.User;

/**
 * @author: yuluo
 * @FileName: UserService.java
 * @createTime: 2022/4/28 21:20
 * @Description:
 */

public interface UserService {

    /**
     * 业务方法，根据用户标识查询用户信息
     * @param id
     * @return
     */
    User queryUserById(Integer id, String username);

}
