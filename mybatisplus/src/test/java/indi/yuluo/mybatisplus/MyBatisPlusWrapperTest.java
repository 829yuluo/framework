package indi.yuluo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import indi.yuluo.mybatisplus.mapper.UserMapper;
import indi.yuluo.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 14:54
 * @File: MyBatisPlusWrapperTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     *  用于测试：wrapper条件构造器组装查询条件
     */
    @Test
    public void test1() {
        // 查询条件: 用户名包含a，年两在20到30之间并且邮箱不为空的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");

        List<User> list = userMapper.selectList(queryWrapper);

        list.forEach(System.out::print);
    }

    /**
     *  用于测试：wrapper条件构造器组装排序条件
     */
    @Test
    public void test2() {
        // 查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                        .orderByAsc("id");

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::print);
    }

    /**
     *  用于测试：wrapper条件构造器组装删除条件
     */
    @Test
    public void test3() {
        // 删除所有邮箱为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");

        int delete = userMapper.delete(queryWrapper);
        // 输出受影响的行数
        System.out.println("delete = " + delete);
    }

    /**
     *  用于测试：wrapper条件构造器组装修改条件
     */
    @Test
    public void test4() {
        // 将（年龄大于20并且用户名中包含a）或邮箱为nul来的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 当条件是and关系是不需要写出and。默认给出and
        // 当条件之间是or关系时，需要用or()来连接
        queryWrapper.gt("age", 20)
                .like("name", "a")
                . or()
                .isNull("email");
        
        // 设置修改的属性
        User user = new User();
        user.setName("huakai");
        user.setEmail("780879337@qq.com");

        // update()两个参数一个设置的是修改的内容，一个是wrapper条件
        int update = userMapper.update(user, queryWrapper);
        System.out.println("update = " + update);
    }

    /**
     *  用于测试：wrapper条件构造器的条件优先级
     */
    @Test
    public void test5() {
        // 将用户名中包含有a并且（年龄大于20或者邮箱为null）的用户信息修改
        // lambda中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));

        // 设置修改的属性
        User user = new User();
        user.setName("huakai love yuluo");
        user.setEmail("780879337@qq.com");

        int update = userMapper.update(user, queryWrapper);
        System.out.println("update = " + update);
    }

    /**
     *  用于测试：组装select子句
     */
    @Test
    public void test6() {
        // 查询用户的用户名、年龄、邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "email");

        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    /**
     *  用于测试：组装子查询
     */
    @Test
    public void test7() {
        // 查询id小于等于100的用户信息
        /*QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("id", 100);

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);*/

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id <= 100");

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     *  用于测试：updateWrapper实现修改功能
     */
    @Test
    public void test8() {
        // 将用户名中包含有a并且（年龄大于20或者邮箱为null）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        // 设置修改内容
        updateWrapper.set("name", "yuluo").set("email", "yuluo@qq.com");


        int update = userMapper.update(null, updateWrapper);
        System.out.println("update = " + update);

    }

    /**
     *  用于测试：模拟实际开发中的场景
     */
    @Test
    public void test9() {
        String name = "a";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 组装条件
        if (StringUtils.isNotBlank(name)) {
            // isNotBlank判断某个字符串是否不为空字符串，不为null，不为空白符
            queryWrapper.like("name", name);
        }

        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.lt("age", ageEnd);
        }

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     *  用于测试：模拟实际开发中的场景 简便方法
     */
    @Test
    public void test10() {
        String name = "a";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    /**
     *  用于测试：测试LambdaQueryWrapper 同test10
     */
    @Test
    public void test11() {
        String name = "a";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(name), User::getName, name)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);

        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    /**
     *  用于测试：LambdaUpdateWrapper实现修改功能
     */
    @Test
    public void test12() {
        // 将用户名中包含有a并且（年龄大于20或者邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName, "a")
                .and(i -> i.gt(User::getAge, 20).or().isNull(User::getEmail));
        // 设置修改内容
        updateWrapper.set(User::getName, "yuluo").set(User::getEmail, "yuluo@qq.com");


        int update = userMapper.update(null, updateWrapper);
        System.out.println("update = " + update);

    }


}
