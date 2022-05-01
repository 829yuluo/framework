package indi.yuluo.mybatisplus;

import indi.yuluo.mybatisplus.mapper.UserMapper;
import indi.yuluo.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yuluo
 * @createTime: 2022/3/15 22:30
 * @File: MyBatisPlusTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    /**
    *  用于测试：查询集合的方法
    */
    @Test
    public void testSelectList() {
        // 通过条件构造器来查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    /**
    *  用于测试：BaseMapper里面的insert方法
    */
    @Test
    public void testInsert() {
        // 准备参数
        User user = new User();
        user.setAge(20);
        user.setName("yuluo");
        user.setEmail("yuluo829@aliyun.com");

        // 调用insert方法插入 返回值为受影响的行数
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

        // 获取生成的id
        System.out.println("id : " + user.getId());
    }

    /**
     *  用于测试：BaseMapper的删除方法
     *  加L表示long类型的数据
     */
    @Test
    public void testDelete() {
        /*int i = userMapper.deleteById(1504020449580343298L);
        System.out.println("i = " + i);*/

        /*// 准备删除的条件
        Map<String, Object> map = new HashMap<>();
        map.put("name", "yuluo");
        map.put("age", 20);
        userMapper.deleteByMap(map);*/

        // 通过多个id来进行批量删除
        List<Long> lists = Arrays.asList(1L, 2L);
        userMapper.deleteBatchIds(lists);

    }

    /**
    *  用于测试：BaseMapper里面的修改方法
    */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3L);
        user.setName("huakai");
        user.setEmail("huakai@qwer.com");

        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    /**
    *  用于测试：BaseMapper里的查询方法
    */
    @Test
    public void testSelect() {
        // 通过id来查询用户信息
        /*User user = userMapper.selectById(3L);
        System.out.println("user = " + user);*/

        // 通过id的集合来批量查询
        /*List<Long> longs = Arrays.asList(3L, 4L);
        List<User> list = userMapper.selectBatchIds(longs);
        list.forEach(System.out::println);*/

        // 根据map集合里的信息进行查询
        Map<String, Object> map = new HashMap<>();
        map.put("name", "huakai");
        map.put("age", "28");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);

    }

    /**
    *  用于测试：自定义查询功能
    */
    @Test
    public void test() {
        Map<String, Object> map = userMapper.selectById(4L);
        System.out.println(map);
    }

}
