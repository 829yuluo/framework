package indi.yuluo;

import indi.yuluo.domian.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yuluo
 * @createTime: 2022/1/21 18:54
 * @File : myTest.java
 * @Software : IntelliJ IDEA
 * @Description:
 */

public class myTest {

    // 测试mybatis执行sql语句
    @Test
    public  void testSelectStudentByID() throws IOException {
        // 调用mybatis某个对象的方法,执行mapper文件中的sql语句
        // mybatis的核心类  SqlSessionFactory

        // 1, 定义mybatis主配置文件的位置, 从类路径开始的相对路径
        String config = "mybatis.xml";
        // 2, 读取主配置文件,使用mybatis框架中的Resources类
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        // 3, 创建SqlSessionFactory对象,使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 4, 获取SqlSeession对象
        SqlSession session = factory.openSession();
        // 5, 确定要执行的sql语句的 id
        // sql的id = namespace + "." + select|update|insert|delete 标签的属性值
        String sqlID = "indi.yuluo.dao.StudentDao" + "." + "selectStudentByID";
        // 6, 通过SqlSession的方法执行sql语句
        Student student = session.selectOne(sqlID);
        // 7, 输出
        System.out.println("使用mybatis查询到的一个学生的信息: " + student);
        // 8, 关闭session对象
        session.close();
    }

    // 测试mybatis执行sql语句时设置占位符
    @Test
    public  void testSelectStudentByID2() throws IOException {
        // 调用mybatis某个对象的方法,执行mapper文件中的sql语句
        // mybatis的核心类  SqlSessionFactory

        // 1, 定义mybatis主配置文件的位置, 从类路径开始的相对路径
        String config = "mybatis.xml";
        // 2, 读取主配置文件,使用mybatis框架中的Resources类
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        // 3, 创建SqlSessionFactory对象,使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 4, 获取SqlSeession对象
        SqlSession session = factory.openSession();
        // 5, 确定要执行的sql语句的 id
        // sql的id = namespace + "." + select|update|insert|delete 标签的属性值
        String sqlID = "indi.yuluo.dao.StudentDao" + "." + "selectStudentByID";
        // 6, 通过SqlSession的方法执行sql语句
        // 后边的参数就是sql语句中的占位符 #{}
        Student student = session.selectOne(sqlID, 1002);
        // 7, 输出
        System.out.println("使用mybatis查询到的一个学生的信息: " + student);
        // 8, 关闭session对象
        session.close();
    }

    // 测试mybatis执行insert操作
    @Test
    public  void testInsertStudent() throws IOException {
        String config = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = factory.openSession();
        // 更改sqlID
        String sqlID = "indi.yuluo.dao.StudentDao" + "." + "insertStudent";
        // 调用session的insert方法进行添加
        // 更改返回值
        int rows = session.insert(sqlID);
        System.out.println("使用mybatis添加到的一个学生的信息: rows = " + rows);

        /**
         * mybatis默认执行sql语句时默认是需要手动提交的,
         * 在做insert update delete后需要手动提交事务
         */
        session.commit();

        session.close();
    }

    // 测试mybatis执行insert操作 使用占位符
    @Test
    public  void testInsertStudent2() throws IOException {
        String config = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = factory.openSession();
        // 更改sqlID
        String sqlID = "indi.yuluo.dao.StudentDao" + "." + "insertStudent";

        // 准备要添加的数据
        Student student = new Student();
        student.setId(1004);
        student.setName("李思思");
        student.setEmail("lisisi@qq.com");
        student.setAge(24);

        // 调用session的insert方法进行添加
        // 更改返回值
        int rows = session.insert(sqlID, student);
        System.out.println("使用mybatis添加到的一个学生的信息: rows = " + rows);

        /**
         * mybatis默认执行sql语句时默认是需要手动提交的,
         * 在做insert update delete后需要手动提交事务
         */
        session.commit();

        session.close();
    }

}
