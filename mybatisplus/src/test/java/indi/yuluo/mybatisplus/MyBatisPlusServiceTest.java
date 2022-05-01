package indi.yuluo.mybatisplus;

import indi.yuluo.mybatisplus.mapper.UserMapper;
import indi.yuluo.mybatisplus.pojo.User;
import indi.yuluo.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuluo
 * @createTime: 2022/3/16 18:13
 * @File: MyBatisPlusServiceTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class MyBatisPlusServiceTest {

    // 自动装配
    @Autowired
    private UserService userService;

    /**
    *  用于测试：
    */
    @Test
    public void testGetCount() {
        // 查询总记录数
        long count = userService.count();
        System.out.println("count = " + count);
    }

    /**
    *  用于测试：通用service的批量添加操作
    */
    @Test
    public void testInsertMore() {

        // 准备数据
        // 批量添加
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();

            user.setName("yuluo" + i);
            user.setAge(20 + i);

            list.add(user);

        }

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);
    }

}
