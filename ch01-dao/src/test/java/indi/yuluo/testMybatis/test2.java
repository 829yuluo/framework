package indi.yuluo.testMybatis;

import indi.yuluo.dao.StudentDao;
import indi.yuluo.dao.impl.StudentDaoImpl;
import indi.yuluo.domain.Student;
import org.junit.Test;

/**
 * @author: yuluo
 * @createTime: 2022/1/22 20:25
 * @File : test2.java
 * @Software : IntelliJ IDEA
 * @Description:
 */

public class test2 {

    /**
     * 用于测试：在实现类中执行Dao接口中的方法
     */
    @Test
    public void testSelectOne() {
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.selectById(1002);
        System.out.println("通过执行实现类中的dao的方法获得的学生对象" + student);
    }

    /**
     * 用于测试：在实现类中执行Dao接口中的方法
     */
    @Test
    public void testInsertStudent() {
        Student studentInfo = new Student();
        studentInfo.setId(1005);
        studentInfo.setName("hongkongdell");
        studentInfo.setEmail("hongkongdell@qq.com");
        studentInfo.setAge(24);
        StudentDao dao = new StudentDaoImpl();
        int rows = dao.insertStudent(studentInfo);
        System.out.println("通过执行实现类中的dao的方法获得的学生对象" + rows);
    }

}
