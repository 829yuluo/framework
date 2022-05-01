package indi.yuluo.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 19:43
 * @File: Product.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@Data
public class Product {

    private Long id;

    private String name;

    private Integer price;

    @Version  // 标识乐观锁版本号字段
    private Integer version;

}
