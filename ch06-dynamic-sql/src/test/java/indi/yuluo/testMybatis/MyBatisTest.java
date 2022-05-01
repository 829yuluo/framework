package indi.yuluo.testMybatis;

import com.github.pagehelper.PageHelper;
import indi.yuluo.dao.StudentDao;
import indi.yuluo.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import indi.yuluo.utils.MyBatisUtils;

import java.util.ArrayList;
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

    /**
     * 用于测试：动态sql语句的if标签
     */
    @Test
    public void testSelectIf() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);

        // 准备参数
        Student student = new Student();
        student.setAge(21);
        student.setName("李思思");

        List<Student> students = mapper.selectIf(student);
        session.close();

        students.forEach(System.out::println);
    }

    /**
     * 用于测试：动态sql语句的where标签
     */
    @Test
    public void testSelectWhere() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        Student student = new Student();
        /*student.setName("huakai");
        student.setAge(24);*/

        List<Student> students = dao.selectWhere(student);
        session.close();

        students.forEach(System.out::println);
    }

    /**
     * 用于测试：foreach的第一种方式
     */
    @Test
    public void testForeach() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Integer> id = new ArrayList<>();
        id.add(1002);
        id.add(1003);
        id.add(1004);
        id = null;

        List<Student> students = dao.selectForeach(id);
        session.close();
        students.forEach(System.out::println);
    }

    /**
     * 用于测试：foreach的第二种方式
     */
    @Test
    public void testSelectForeach2() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao mapper = session.getMapper(StudentDao.class);

        List<Student> student = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setId(1002);
        student2.setId(1005);
        student.add(student1);
        student.add(student2);

        student = null;

        PageHelper.startPage(1, 2);
        List<Student> students = mapper.selectForeach2(student);

        session.close();
        students.forEach(stu-> System.out.println("stu = " + stu));
    }
}
