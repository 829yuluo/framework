package indi.yuluo.springbootRESTful.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import indi.yuluo.springbootRESTful.dao.Studentdao;
import indi.yuluo.springbootRESTful.enity.Student;
import indi.yuluo.springbootRESTful.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author: yuluo
 * @FileName: IndexService.java
 * @createTime: 2022/5/8 16:48
 * @Description:
 */

@Service
public class StudentServiceImpl extends ServiceImpl<Studentdao, Student> implements StudentService {

}
