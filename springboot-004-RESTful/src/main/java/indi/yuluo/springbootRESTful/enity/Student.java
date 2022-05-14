package indi.yuluo.springbootRESTful.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yuluo
 * @FileName: Student.java
 * @createTime: 2022/5/8 16:50
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private String email;

    private Integer age;

}
