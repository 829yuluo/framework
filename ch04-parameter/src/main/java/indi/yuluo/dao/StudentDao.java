package indi.yuluo.dao;

import indi.yuluo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    Student selectById(Integer id);

    /**
     * 通过邮箱查询学生信息
     * @param email
     * @return Student
     */
    Student selectByEmail(String email);

    /**
     * 有多个简单参数
     * 使用@param命名参数 注解是mybatis提供的
     * 位置：在形参定义的前面
     * 属性：value自定义的参数名称
     *
     * @param name
     * @param age
     * @return student
     */
    List<Student> selectStudentByAgeOrName(@Param("studentName") String name,
                                           @Param("studentAge") Integer age);

    /**
     * 一个java对象作为参数，对象有属性，每个属性有set和get方法
     * @param student
     * @return studentList
     */
    List<Student> selectByObject(Student student);

    /**
     * 使用位置获取参数值
     * @param name
     * @param age
     * @return studentlist
     */
    List<Student> selectByPosition(String name, Integer age);

    /**
     * 使用${}接受参数
     * @param name 要查询的学生姓名
     * @return studentList
     */
    List<Student> selectQueryStudent(@Param("studentName") String name);

    /**
     * 传递列名进行排序
     * @param colName
     * @return
     */
    List<Student> queryStudentOrderByColname(@Param("colName") String colName);
}
