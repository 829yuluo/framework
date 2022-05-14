package indi.yuluo.springbootRESTful;

import indi.yuluo.springbootRESTful.dao.Studentdao;
import indi.yuluo.springbootRESTful.enity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: yuluo
 * @FileName: TestDao.java
 * @createTime: 2022/5/8 17:03
 * @Description:
 */

@SpringBootTest
public class TestDao {

    @Autowired
    private Studentdao studentdao;

    @Test
    void test() {
        List<Student> students = studentdao.selectList(null);
        students.forEach(System.out::println);
    }

}
