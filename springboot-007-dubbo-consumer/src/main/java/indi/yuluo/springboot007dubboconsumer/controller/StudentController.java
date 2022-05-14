package indi.yuluo.springboot007dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import indi.yuluo.springboot.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yuluo
 * @FileName: StudentController.java
 * @createTime: 2022/5/13 11:06
 * @Description:
 */

@Controller
public class StudentController {

    // dubbo:reference interface="" version="" check=false  代替dubbo的配置
    @Reference(interfaceClass = StudentService.class, version="1.0.0", check=false)
    private StudentService studentService;

    @GetMapping(value = "/student/count")
    public @ResponseBody Object studentCount() {

        Integer count = studentService.queryAllStudentCount();

        return "学生总数为：" + count;
    }

}
