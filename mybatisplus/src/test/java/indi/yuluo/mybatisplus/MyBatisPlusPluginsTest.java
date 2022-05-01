package indi.yuluo.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.yuluo.mybatisplus.mapper.UserMapper;
import indi.yuluo.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 17:24
 * @File: MyBatisPlusPluginsTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    /**
     *  用于测试：
     */
    @Test
    public void testPage() {

        // mysql数据库使用的是limit关键字来进行分页操作
        // limit后面的两个参数是页码和展示的记录条数
        Page<User> page = new Page<User>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page);

    }

    /**
     *  用于测试：自定义的分页功能
     */
    @Test
    public void testPageVo() {
        Page<User> page = new Page<User>(1, 3);
        userMapper.selectPageVo(page, 20);
        System.out.println(page);
    }

}
