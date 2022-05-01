package indi.yuluo.mybatisplus;

import indi.yuluo.mybatisplus.enums.SexEnum;
import indi.yuluo.mybatisplus.mapper.UserMapper;
import indi.yuluo.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 21:24
 * @File: MyBatisPlusEnumTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    /**
     *  用于测试：
     */
    @Test
    public void test() {
        User user = new User();
        user.setAge(20);
        user.setEmail("huakai@qq.com");
        user.setName("huakai");
        user.setSex(SexEnum.FEMALE);

        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

}
