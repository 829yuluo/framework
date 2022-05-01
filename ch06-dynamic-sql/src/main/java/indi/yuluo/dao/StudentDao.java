package indi.yuluo.dao;

import indi.yuluo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 动态sql之if语句
     * @param student
     * @return
     */
    List<Student> selectIf(Student student);

    /**
     * 动态sql语句的where标签
     * @param student
     * @return student
     */
    List<Student> selectWhere(Student student);

    /**
     * 使用foreach进行动态sql语句的拼接
     * 循环简单类型的List集合
     * @param idList
     * @return list
     */
    List<Student> selectForeach(List<Integer> idList);

    /**
     * foreach对对象类型的集合遍历
     * @param students
     * @return
     */
    List<Student> selectForeach2(List<Student> students);

}
