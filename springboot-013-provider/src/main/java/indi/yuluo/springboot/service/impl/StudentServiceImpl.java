package indi.yuluo.springboot.service.impl;

import bean.Student;
import com.alibaba.dubbo.config.annotation.Service;
import indi.yuluo.springboot.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.StudentService;

/**
 * @author: yuluo
 * @FileName: StudentServiceImpl.java
 * @createTime: 2022/5/14 12:57
 * @Description:
 */

@Component
@Service(interfaceClass = StudentService.class, version="1.0.0", timeout = 15000)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectById(id);
    }
}
