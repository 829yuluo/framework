package indi.yuluo.dubbo.service;

import indi.yuluo.dubbo.model.User;

/**
 * @author: yuluo
 * @FileName: UserService.java
 * @createTime: 2022/4/28 16:18
 * @Description: 接口
 */

public interface UserService {

    /**
     * 根据用户标识获取用户信息
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 查询用户总人数
     * @return
     */
    Integer queryAllUSerCount();
}
