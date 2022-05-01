package indi.yuluo.testMybatis;

import indi.yuluo.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import indi.yuluo.utils.MyBatisUtils;

import java.util.List;

/**
 * @author: yuluo
 * @createTime: 2022/1/22 19:39
 * @File : test.java
 * @Software : IntelliJ IDEA
 * @Description:
 */

public class MyBatisTest {

    /**
     * 用于测试：mybatis的工具类
     */
    @Test
    public void testUtils() {
        // 获取Sqlsession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 指定SqlId
        String sqlId = "indi.yuluo.dao.StudentDao.selectById";
        // 用SqlSession的方法 执行sql语句
        Student student = sqlSession.selectOne(sqlId, 1001);
        // 输出
        System.out.println(student);
        // 关闭sqlSession对象
        sqlSession.close();
    }

    /**
     * 用于测试：使用selectList()获得一个学生列表
     */
    @Test
    public void testSelectStudents() {
        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 指定SqlId
        String sqlId = "indi.yuluo.dao.StudentDao.selectStudents";
        // 用SqlSession的方法 执行sql语句
        List<Student> studentsList = sqlSession.selectList(sqlId);
        // 输出
        for (Student student : studentsList) {
            System.out.println("student = " + student);
        }
        // 关闭sqlSession对象
        sqlSession.close();
    }

    /**
     * 用于测试：使用selectList()获得一个学生列表
     */
    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setId(1003);
        student.setName("张三");
        student.setEmail("zhangsan@qq.com");
        student.setAge(21);

        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 指定SqlId
        String sqlId = "indi.yuluo.dao.StudentDao.insertStudent";
        // 用SqlSession的方法 执行insert语句
        int insertrows = sqlSession.insert(sqlId, student);
        // 提交事务
        sqlSession.commit();
        // 输出
        System.out.println("insert影响数据库的行数 = " + insertrows);
        // 关闭sqlSession对象
        sqlSession.close();
    }
}
