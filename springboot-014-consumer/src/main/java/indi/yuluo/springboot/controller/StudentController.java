package indi.yuluo.springboot.controller;

import bean.Student;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;

/**
 * @author: yuluo
 * @FileName: StudentController.java
 * @createTime: 2022/5/14 12:49
 * @Description:
 */

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Reference(interfaceClass = StudentService.class, version = "1.0.0", check = false)
    private StudentService studentService;

    @RequestMapping(value = "/detail/{id}")
    public String detail(
            Model model,
            @PathVariable("id") Integer id) {

        // 根据学生ID查询详情
        Student student = studentService.queryStudentById(id);

        model.addAttribute("student", student);

        return "StudentDetail";
    }

}
