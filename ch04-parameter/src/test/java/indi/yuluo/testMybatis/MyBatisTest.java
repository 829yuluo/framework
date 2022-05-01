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

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectById(1005);

        System.out.println("student = " + student);
        sqlSession.close();
    }

    /**
     * 用于测试：简单类型的参数
     */
    @Test
    public void testSelectByEmail() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student = mapper.selectByEmail("hongkongdell@qq.com");

        System.out.println(student);

        session.close();
    }

    /**
     * 用于测试：使用注解获取简单类型的参数
     */
    @Test
    public void testSelectStudentByAgrOrName() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> studentInfo = mapper.selectStudentByAgeOrName("yuluo", 21);

        studentInfo.forEach(System.out::println);

        session.close();
    }

    /**
     * 用于测试：将一个java对象的属性值作为参数
     */
    @Test
    public void testSelectByObject() {
        Student student = new Student();
        student.setName("yuluo");
        student.setAge(21);
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> studentInfo = mapper.selectByObject(student);

        studentInfo.forEach(System.out::println);

        session.close();
    }

    /**
     * 用于测试：使用位置获取参数
     */
    @Test
    public void testSelectByPosition() {

        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> studentInfo = mapper.selectByPosition("huakai", 21);

        studentInfo.forEach(System.out::println);

        session.close();
    }

    /**
     * 用于测试${}的使用
     */
    @Test
    public void testSelectQueryStudent() {

        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> studentInfo = mapper.selectQueryStudent("'yuluo'");
        /*List<Student> studentInfo = mapper.selectQueryStudent("'yuluo' or id > 1000");*/

        studentInfo.forEach(System.out::println);

        session.close();
    }

    /**
     * 用于测试：使用 ${} 传递数据库的列名进行排序
     */
    @Test
    public void testQueryStudentOrderByColname() {

        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> studentInfo = mapper.queryStudentOrderByColname("name");

        studentInfo.forEach(System.out::println);

        session.close();
    }
}
