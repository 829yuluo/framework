package indi.yuluo.springboot.bean;

import java.io.Serializable;

/**
 * @author: yuluo
 * @FileName: Student.java
 * @createTime: 2022/5/13 11:16
 * @Description:
 */

public class Student implements Serializable {

    private Integer id;

    private String name;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
