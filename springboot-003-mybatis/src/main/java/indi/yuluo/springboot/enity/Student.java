package indi.yuluo.springboot.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yuluo
 * @FileName: Student.java
 * @createTime: 2022/5/8 12:19
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
