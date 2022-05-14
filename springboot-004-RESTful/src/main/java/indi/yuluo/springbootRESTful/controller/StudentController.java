package indi.yuluo.springbootRESTful.controller;

import indi.yuluo.springbootRESTful.enity.Student;
import indi.yuluo.springbootRESTful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: yuluo
 * @FileName: IndexController.java
 * @createTime: 2022/5/8 16:44
 * @Description:
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public List<Student> findAll() {

        return studentService.list(null);
    }

    @PostMapping("/save/{id}/{name}/{age}")
    public void save(
            @PathVariable("id") Integer id,
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ) {

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setEmail("test@yuluo.com");

        studentService.save(student);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable("id") Integer id) {

        Student student = new Student();
        student.setId(id);
        student.setName("test1");

        return studentService.updateById(student);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {

        Student student = new Student();
        student.setId(id);

        return studentService.removeById(student);
    }

}
