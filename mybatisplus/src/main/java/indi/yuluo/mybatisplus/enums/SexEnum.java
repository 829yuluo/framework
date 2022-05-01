package indi.yuluo.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 20:28
 * @File: SexEnum.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@Getter
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    // 注解的作用是将标识的属性的值存放到数据库中
    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
