package indi.yuluo.dao.impl;

import indi.yuluo.dao.StudentDao;
import indi.yuluo.domain.Student;
import indi.yuluo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author: yuluo
 * @createTime: 2022/1/22 20:22
 * @File : studentDaoImpl.java
 * @Software : IntelliJ IDEA
 * @Description: 真正的执行StudentDao接口中的方法的办法是在相映的实现类中实现方法
 */

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student selectById(Integer id) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "indi.yuluo.dao.StudentDao.selectById";
        Student student = sqlSession.selectOne(sqlId, id);
        sqlSession.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        return null;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "indi.yuluo.dao.StudentDao.insertStudent";
        int rows = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        return rows;
    }
}
