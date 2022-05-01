package indi.exer.yuluo.life;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: yuluo
 * @createTime: 2021/12/3 17:10
 * @Description:
 *      1.对象的初始化和销毁注解不是spring提供的，是JSR（javaEE规范）520提供的
 *      2.通过注解实现了接口的契约性
 */

@Component
public class Product {

    /**
     * 初始化方法
     */
    @PostConstruct
    public void myInit() {
        System.out.println("Product.myInit");
    }

    /**
     * 销毁方法
     */
    @PreDestroy
    public void myDestory() {
        System.out.println("Product.mydestory");
    }

}
