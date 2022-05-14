package indi.yuluo.springboot008nowebjava.service.impl;

import indi.yuluo.springboot008nowebjava.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @FileName: StudentServiceImpl.java
 * @createTime: 2022/5/13 20:43
 * @Description:
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
