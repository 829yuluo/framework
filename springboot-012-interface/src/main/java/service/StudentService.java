package service;

import bean.Student;

/**
 * @author: yuluo
 * @FileName: StudentService.java
 * @createTime: 2022/5/14 12:58
 * @Description:
 */

public interface StudentService {

    /**
     * 根据学生id查询学生信息
     * @return
     */
    Student queryStudentById(Integer id);
}
