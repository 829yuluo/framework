package indi.yuluo.springboot;

import indi.yuluo.springboot.dao.StudentMapper;
import indi.yuluo.springboot.enity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: yuluo
 * @FileName: TestDao.java
 * @createTime: 2022/5/8 12:27
 * @Description:
 */

@SpringBootTest
public class TestDao {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void testDao() {
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);
    }


}
