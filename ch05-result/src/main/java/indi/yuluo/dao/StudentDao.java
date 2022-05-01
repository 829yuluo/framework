package indi.yuluo.dao;

import indi.yuluo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    Student selectById(Integer id);

    /**
     * 得到student这张表的记录数
     * @return
     */
    Integer countStudent();

    // 返回结果是一个Map
    Map<Object, Object> selectByMap(@Param("studentId") Integer id);

    List<Student> selectLikeFirst(@Param("studentLikeName") String name);

    List<Student> selectLikeSecond(@Param("studentLikeName") String name);
}
