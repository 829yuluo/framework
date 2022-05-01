package indi.yuluo.testMybatis;

import indi.yuluo.dao.StudentDao;
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

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        /*String sqlId = "indi.yuluo.dao.StudentDao.selectById";
        Student student = sqlSession.selectOne(sqlId, 1001);*/

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectById(1005);

        System.out.println("student = " + student);
        sqlSession.close();

    }

    /**
     * 用于测试：dao代理的自动选择选择方法返回list
     */
    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao====" + dao.getClass().getName());
        List<Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
        sqlSession.close();
    }
}
