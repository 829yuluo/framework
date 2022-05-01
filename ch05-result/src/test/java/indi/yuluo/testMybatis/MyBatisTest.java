package indi.yuluo.testMybatis;

import indi.yuluo.dao.StudentDao;
import indi.yuluo.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import indi.yuluo.utils.MyBatisUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: yuluo
 * @createTime: 2022/1/22 19:39
 * @File : test.java
 * @Software : IntelliJ IDEA
 * @Description:
 */

public class MyBatisTest {

    @Test
    public void testUtils() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectById(1005);

        System.out.println("student = " + student);
        sqlSession.close();
    }

    /**
     * 用于测试：resultType表示简单类型
     */
    @Test
    public void test() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        Integer integer = dao.countStudent();
        System.out.println(integer);

        session.close();
    }

    /**
     * 用于测试：resultMap 返回的是一个map的数据结构
     */
    @Test
    public void testSelectByMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        Map<Object, Object> objectObjectMap = mapper.selectByMap(1002);

        System.out.println(objectObjectMap);
        sqlSession.close();
    }

    /**
     * 用于测试：like模糊查询的第一种方式
     */
    @Test
    public void testSelectLikeName() {
        SqlSession session = MyBatisUtils.getSqlSession();

        StudentDao mapper = session.getMapper(StudentDao.class);

        // 对like的值进行字符串拼接
        String name = "%u%";
        List<Student> u = mapper.selectLikeFirst(name);

        u.forEach(System.out::println);

        session.close();
    }

    /**
     * 用于测试：like模糊查询的第二种方式
     */
    @Test
    public void testSelectLikeSecond() {
        SqlSession session = MyBatisUtils.getSqlSession();

        StudentDao mapper = session.getMapper(StudentDao.class);

        // 对like的值进行字符串拼接
        String name = "y";
        List<Student> u = mapper.selectLikeFirst(name);

        u.forEach(System.out::println);

        session.close();
    }
}
