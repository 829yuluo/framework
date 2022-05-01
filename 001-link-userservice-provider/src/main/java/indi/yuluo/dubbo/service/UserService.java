package indi.yuluo.dubbo.service;

import indi.yuluo.dubbo.model.User;

/**
 * @author: yuluo
 * @FileName: UserService.java
 * @createTime: 2022/4/27 13:04
 * @Description: 接口
 */

public interface UserService {

    /**
     * 根据用户的id查询用户信息
     * @param id
     * @return
     */
    User queryUserById(Integer id);

}
