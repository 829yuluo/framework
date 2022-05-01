package indi.yuluo.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import indi.yuluo.mybatisplus.enums.SexEnum;
import lombok.Data;

/**
 * @author: yuluo
 * @createTime: 2022/3/15 22:19
 * @File: User.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;

}
