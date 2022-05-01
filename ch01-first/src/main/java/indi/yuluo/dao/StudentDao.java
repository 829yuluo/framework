package indi.yuluo.dao;

import indi.yuluo.domian.Student;

public interface StudentDao {

    // 查询一个学生
    Student selectStudentByID(Integer id);

    // 添加学生
    // 返回值int表示此操作影响数据库的行数
    int insertStudent(Student student);
}
